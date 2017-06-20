package org.light4j.consistency.hash.one;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 实现方案一：
 * <p>
 * 一致性哈希环
 * 
 * @author longjiazuo
 * 
 * @param <M>
 */
public class ConsistentHashing<M> {

	// 真实机器节点
	private List<M> machines;
	// 虚拟节点
	private TreeMap<Long, M> nodes;
	// 每个机器节点关联的虚拟节点个数
	private final int NODE_NUM = 100;

	public ConsistentHashing(List<M> machines) {
		this.machines = machines;
		this.init();
	}

	/**
	 * 初始化一致性hash环
	 */
	private void init() {
		nodes = new TreeMap<Long, M>();
		// 每个真实机器节点都需要关联指定数量的虚拟节点
		for (int i = 0; i != machines.size(); ++i) {
			final M machine = machines.get(i);
			this.addNodes(machine, i);
		}
	}

	/**
	 * 根据key获取Machine
	 * 
	 * @param key
	 * @return
	 */
	public M getMachineByKey(String key) {
		// 沿环的顺时针找到一个虚拟节点
		SortedMap<Long, M> tail = nodes.tailMap(MurMurHash.hash(key));
		if (tail.size() == 0) {
			return nodes.get(nodes.firstKey());
		}
		// 返回该虚拟节点对应的真实机器节点的信息
		return tail.get(tail.firstKey());
	}

	/**
	 * 添加机器
	 * 
	 * @param machine
	 * @return
	 */
	public List<M> addMachine(M machine) {
		if (machine != null) {
			this.machines.add(machine);
			this.addNodes(machine, machines.size());
		}
		return machines;
	}

	/**
	 * 移除机器
	 * 
	 * @param machine
	 * @return
	 */
	public List<M> removeMachine(M machine) {
		if (machine != null) {
			for (int i = 0; i < machines.size(); i++) {
				if (machines.get(i).equals(machine)) {
					this.machines.remove(i);
					this.removeNodes(machine, i);
				}
			}
		}
		return machines;
	}

	/**
	 * 根据物理结点添加虚拟结点
	 * <p>
	 * 一个真实机器节点关联NODE_NUM个虚拟节点
	 * 
	 * @param machine
	 * @param i
	 */
	private void addNodes(M machine, int i) {
		for (int n = 0; n < NODE_NUM; n++) {
			nodes.put(MurMurHash.hash(makeHashStrByIndex(i, n)), machine);
		}
	}

	/**
	 * 根据物理结点移除虚拟结点
	 * <p>
	 * 一个真实机器节点关联NODE_NUM个虚拟节点
	 * 
	 * @param machine
	 * @param i
	 */
	private void removeNodes(M machine, int i) {
		for (int n = 0; n < NODE_NUM; n++) {
			nodes.remove(MurMurHash.hash(makeHashStrByIndex(i, n)));
		}
	}

	/**
	 * 自定义构造规则
	 * <p>
	 * 构造需要进行Hash的字符串
	 * 
	 * @param machineIndex
	 * @param nodeIndex
	 * @return
	 */
	public String makeHashStrByIndex(int machineIndex, int nodeIndex) {
		return "MACHINE-" + machineIndex + "-NODE-" + nodeIndex;
	}

	/**
	 * 获取所有的物理结点
	 * 
	 * @return
	 */
	public List<M> getMachines() {
		return machines;
	}

	/**
	 * 获取所有的虚结点
	 * 
	 * @return
	 */
	public TreeMap<Long, M> getNodes() {
		return nodes;
	}
}