package org.light4j.thread.control;

/**
 * 线程优先级Priority使用
 * 
 * @author longjiazuo
 * 
 */
public class PriorityTest extends Thread {

	public PriorityTest(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println(getName() + ",其优先级是：" + getPriority()
					+ ",循环变量的值是：" + i);
		}
	}

	public static void main(String[] args) {
		// 改变主线程的优先级
		Thread.currentThread().setPriority(6);
		for (int i = 0; i < 30; i++) {
			if (i == 10) {
				PriorityTest low = new PriorityTest("低级");
				low.start();
				System.out.println("低级创建之初的线程优先级是：" + low.getPriority());
				// 将该线程设置为最低优先级
				low.setPriority(Thread.MIN_PRIORITY);
			}

			if (i == 20) {
				PriorityTest high = new PriorityTest("高级");
				high.start();
				System.out.println("高级创建之初的线程优先级是：" + high.getPriority());
				// 将该线程设置为最高优先级
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}