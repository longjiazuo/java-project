package org.light4j.consistency.hash.one;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		// 初始化机器信息
		Machine m1 = new Machine("node-1", null, "192.168.0.1", null);
		Machine m2 = new Machine("node-2", null, "192.168.0.2", null);
		Machine m3 = new Machine("node-3", null, "192.168.0.3", null);
		Machine m4 = new Machine("node-4", null, "192.168.0.4", null);
		Machine m5 = new Machine("node-5", null, "192.168.0.5", null);
		List<Machine> ms = new ArrayList<>();
		ms.add(m1);
		ms.add(m2);
		ms.add(m3);
		ms.add(m4);

		//初始化哈希环
		ConsistentHashRing<Machine> hashRing = new ConsistentHashRing<>(ms);
		System.out.println(hashRing.getMachineByKey(hashRing
				.makeHashStrByIndex(1, 2)));
		System.out.println(hashRing.getNodes().size());
		System.out.println(hashRing.getMachines());

		// 添加机器
		hashRing.addMachine(m5);
		System.out.println(hashRing.getNodes().size());
		System.out.println(hashRing.getMachines());

		// 移除机器
		hashRing.removeMachine(m2);
		System.out.println(hashRing.getNodes().size());
		System.out.println(hashRing.getMachines());
	}
}