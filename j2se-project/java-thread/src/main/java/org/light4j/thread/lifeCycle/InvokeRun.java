package org.light4j.thread.lifeCycle;

/**
 * 测试直接调用run()方法的效果
 * 
 * @author longjiazuo
 * 
 */
public class InvokeRun extends Thread {

	private int i;

	@Override
	public void run() {
		for (; i < 10; i++) {
			// 如果直接调用run()方法时，Thread的this.getName()返回的是该对象的名字
			// 而不是当前线程的名字
			// 使用Thread.currentThread().getName()总是获取当前线程的名字
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 5) {
				// 直接调用线程对象的run()方法
				new InvokeRun().run();
				new InvokeRun().run();
			}
		}
	}
}