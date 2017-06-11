package org.light4j.thread.communicate;

/**
 * 线程yield()方法使用测试
 * 
 * @author longjiazuo
 * 
 */
public class YieldTest extends Thread {
	public YieldTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + " " + i);
			if (i == 20) {
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) {
		// 启动两个并发线程
		YieldTest yt1 = new YieldTest("高级线程");
		// 将线程yt1设置成最高优先级
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		YieldTest yt2 = new YieldTest("低级线程");
		// 将线程yt2设置成最低优先级
		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.start();
	}
}