package org.light4j.net.basic;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * <p>
 * URL(Uniform Resource
 * Locator)对象代表统一资源定位符,它是指向互联网"资源"的指针。资源可以是简单的文件或者目录,也可以是对更为复杂对象的引用
 * ,例如对数据库或者搜索引擎的查询
 * ,在通常情况下,URL可以由协议名,主机,端口和资源组成,即满足这样的格式：protocol://host:port/resourceName
 * <p>
 * <p>
 * JDK中还提供了一个URI(Uniform Resource
 * Identifiers)类,其实例代表一个统一资源标识符,Java的URI不能用于定位任何资源
 * ,它的唯一作用就是解析,与此对应的是URL则包含一个可打开到达该资源的输入流,可以将URL理解成URI的特例。
 * <p>
 * <p>
 * 下面程序中DownUtil类中的download()方法负责按如下步骤来实现多线程下载：
 * (1). 创建URL对象
 * (2). 获取指定URL对象所指向的资源的大小(通过getCotentLength()方法获得),此处用到了URLConnection类,该类代表Java应用程序和URL之间的通信链接。
 * (3). 在本地磁盘上面创建一个与网络资源具有相同大小的空文件。
 * (4). 计算每个线程应该下载网络资源的哪个部分(从哪个字节开始,到哪个字节结束)。
 * (5). 依次创建,启动多个线程来下载网络资源的指定部分。
 * <p>
 * 
 * @author longjiazuo
 * @date 2017年4月8日 下午10:11:09
 */
public class DownUtil {
	// 定义下载资源的路径
	private String path;
	// 指定所下载的文件的保存位置
	private String targetFile;
	// 定义需要使用多少个线程下载资源
	private int threadNum;
	// 定义下载的线程对象
	private DownThread[] threads;
	// 定义下载的文件的总大小
	private int fileSize;

	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.threadNum = threadNum;
		// 初始化threads数组
		threads = new DownThread[threadNum];
		this.targetFile = targetFile;
	}

	public void download() throws Exception {
		URL url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("GET");
		conn.setRequestProperty(
				"Accept",
				"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
						+ "application/x-shockwave-flash, application/xaml+xml, "
						+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
						+ "application/x-ms-application, application/vnd.ms-excel, "
						+ "application/vnd.ms-powerpoint, application/msword, */*");
		conn.setRequestProperty("Accept-Language", "zh-CN");
		conn.setRequestProperty("Charset", "UTF-8");
		conn.setRequestProperty("Connection", "Keep-Alive");
		// 得到文件大小
		fileSize = conn.getContentLength();
		conn.disconnect();
		int currentPartSize = fileSize / threadNum + 1;
		RandomAccessFile file = new RandomAccessFile(targetFile, "rw");
		// 设置本地文件的大小
		file.setLength(fileSize);
		file.close();
		for (int i = 0; i < threadNum; i++) {
			// 计算每个线程下载的开始位置
			int startPos = i * currentPartSize;
			// 每个线程使用一个RandomAccessFile进行下载
			RandomAccessFile currentPart = new RandomAccessFile(targetFile,
					"rw");
			// 定义该线程的下载位置
			currentPart.seek(startPos);
			// 创建下载线程
			threads[i] = new DownThread(startPos, currentPartSize, currentPart);
			// 启动下载线程
			threads[i].start();
		}
	}

	// 获取下载的完成百分比
	public double getCompleteRate() {
		// 统计多个线程已经下载的总大小
		int sumSize = 0;
		for (int i = 0; i < threadNum; i++) {
			sumSize += threads[i].length;
		}
		// 返回已经完成的百分比
		return sumSize * 1.0 / fileSize;
	}

	private class DownThread extends Thread {
		// 当前线程的下载位置
		private int startPos;
		// 定义当前线程负责下载的文件大小
		private int currentPartSize;
		// 当前线程需要下载的文件块
		private RandomAccessFile currentPart;
		// 定义已经下载的字节数
		private int length;

		// 定义该下载已经下载的字节数
		public DownThread(int startPos, int currentPartSize,
				RandomAccessFile currentPart) {
			this.startPos = startPos;
			this.currentPartSize = currentPartSize;
			this.currentPart = currentPart;
		}

		@Override
		public void run() {
			try {
				URL url = new URL(path);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection();
				conn.setConnectTimeout(5 * 1000);
				conn.setRequestMethod("GET");
				conn.setRequestProperty(
						"Accept",
						"image/gif, image/jpeg, image/pjpeg, image/pjpeg, "
								+ "application/x-shockwave-flash, application/xaml+xml, "
								+ "application/vnd.ms-xpsdocument, application/x-ms-xbap, "
								+ "application/x-ms-application, application/vnd.ms-excel, "
								+ "application/vnd.ms-powerpoint, application/msword, */*");
				conn.setRequestProperty("Accept-Language", "zh-CN");
				conn.setRequestProperty("Charset", "UTF-8");
				InputStream inputStream = conn.getInputStream();
				// 跳过startPos个字节,表明该线程只下载自己负责的那部分文件
				inputStream.skip(this.startPos);
				byte[] buffer = new byte[1024];
				int hasRead = 0;
				// 读取网络数据,并写入本地文件
				while (length < currentPartSize
						&& (hasRead = inputStream.read(buffer)) != -1) {
					currentPart.write(buffer, 0, hasRead);
					// 累计该线程下载的总大小
					length += hasRead;
				}
				currentPart.close();
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}