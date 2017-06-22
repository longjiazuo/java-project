package org.light4j.load.balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 常用的负载均衡算法：
 * <p>
 * 1. 轮询
 * <p>
 * 2. 随机
 * <p>
 * 3. 源地址哈希
 * <p>
 * 4. 加权轮询
 * <p>
 * 5. 加权随机
 * <p>
 * 6. 最小连接(最小连接数需要计算服务器连接数，操作比较复杂，这里不演示)
 * 
 * @author longjiazuo
 * 
 */
public class LoadBalance {

	// 保存服务器地址和权重的Map：key为ip，value为全权重
	private static Map<String, Integer> serverWeight = new HashMap<String, Integer>();

	// 记录当前访问的服务器编号
	private static Integer pos = 0;
	static {
		// 权重为1的ip
		serverWeight.put("192.016.1.100", 1);
		serverWeight.put("192.016.1.101", 1);
		serverWeight.put("192.016.1.102", 1);
		serverWeight.put("192.016.1.103", 1);
		serverWeight.put("192.016.1.104", 1);
		// 权重为2的ip
		serverWeight.put("192.016.1.105", 2);
		serverWeight.put("192.016.1.106", 2);
		// 权重为3的ip
		serverWeight.put("192.016.1.107", 3);
		serverWeight.put("192.016.1.108", 3);
		serverWeight.put("192.016.1.109", 3);
		// 权重4的ip
		serverWeight.put("192.016.1.110", 4);
	}

	/**
	 * 获取ip列表
	 * 
	 * @param weight
	 *            是否加权,true代表加权，false代表不加权
	 * @return
	 */
	public static List<String> getIpList(boolean ifWeight) {
		// 重新创建新的Map，避免出现服务器的上线下线导致的并发问题
		Map<String, Integer> serverMap = new HashMap<>();
		serverMap.putAll(serverWeight);
		// 获取ip地址的列表
		List<String> ipList = new ArrayList<>();
		Set<String> ipSet = serverMap.keySet();
		// 加权
		if (ifWeight) {
			Iterator<String> ipIterator = ipSet.iterator();
			while (ipIterator.hasNext()) {
				String ip = ipIterator.next();
				Integer weight = serverMap.get(ip);
				// 根据权重大小将地址重复的增加到服务器地址列表中
				// 所以权重越大，服务器每轮获得的请求数量越多
				for (int i = 0; i < weight; i++) {
					ipList.add(ip);
				}
			}
		} else {
			ipList.addAll(ipSet);
		}
		return ipList;
	}

	/**
	 * 轮询(Round Robin)
	 * <p>
	 * 轮询：将请求按照顺序轮流地分配到后端服务器，均衡的对待每一台服务器。
	 * 
	 * @return
	 */
	public static String getServerByRoundRobin() {
		List<String> ipList = getIpList(false);
		String server = null;
		synchronized (pos) {
			// 如果编号已经超过了服务器的数量则重新从0开始
			if (pos >= ipList.size()) {
				pos = 0;
			}
			server = ipList.get(pos);
			pos++;
		}
		return server;
	}

	/**
	 * 随机(Random)
	 * <p>
	 * 随机：从服务器中随机选取一台服务器进行访问
	 * 
	 * @return
	 */
	public static String getServerByRandom() {
		List<String> ipList = getIpList(false);

		// 创建随机数对象
		Random random = new Random();
		// 获取随机位置
		int randomPos = random.nextInt(ipList.size());
		return ipList.get(randomPos);
	}

	/**
	 * 源地址哈希(Ip Hash)
	 * <p>
	 * 源地址哈希：通过哈希函数计算客户端访问的IP地址值，用该值对服务器的总数进行取摸运算,得到的结果便是要访问的服务器的序号。
	 * 
	 * @return
	 */
	public static String getServerByIpHash() {
		List<String> ipList = getIpList(false);

		// 获取客户端访问的IP地址
		String remoteIp = "192.016.1.107";
		// 取哈希值
		Integer hashCode = remoteIp.hashCode();

		// 获取服务器序号,hashCode可能为负数，取绝对值容错
		Integer serverPos = Math.abs(hashCode % ipList.size());
		return ipList.get(serverPos);
	}

	/**
	 * 加权轮询(Weight Round Robin)
	 * <p>
	 * 加权轮询：将请求按照权重大小分配到后端服务器，权重比较大的服务器获取访问的次数多。
	 * 
	 * @return
	 */
	public static String getServerByWeightRoundRobin() {
		List<String> ipList = getIpList(true);
		String server = null;
		synchronized (pos) {
			// 如果编号已经超过了服务器的数量则重新从0开始
			if (pos >= ipList.size()) {
				pos = 0;
			}
			server = ipList.get(pos);
			pos++;
		}
		return server;
	}

	/**
	 * 加权随机(Weight Random)
	 * <p>
	 * 加权随机：根据权重大小从服务器中随机选取一台服务器进行访问
	 * 
	 * @return
	 */
	public static String getServerWeightByRandom() {
		List<String> ipList = getIpList(true);

		// 创建随机数对象
		Random random = new Random();
		// 获取随机位置
		int randomPos = random.nextInt(ipList.size());
		return ipList.get(randomPos);
	}

	public static void main(String[] args) {
		for (int i= 0; i < 20; i++) {
			System.out.println(getServerByRoundRobin());
		}
	}
}