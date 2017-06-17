package org.light4j.thread.threadGroup;

/**
 * 线程组ThreadGroup测试
 * 
 * @author longjiazuo
 * 
 */
class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	public MyThread(ThreadGroup group, String name) {
		super(group, name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "线程i的变量是：" + i);
		}
	}
}

public class ThreadGroupTest {
	public static void main(String[] args) {
		System.out.println("主线程所在的线程组名字是："
				+ Thread.currentThread().getThreadGroup().getName());
		System.out.println("主线程所在的线程组是否是后台进程："
				+ Thread.currentThread().isDaemon());
		new MyThread("主线程组的线程").start();

		ThreadGroup tg = new ThreadGroup("新线程组");
		// 将新线程组设置为后台进程
		tg.setDaemon(true);
		System.out.println("新线程组是否是后台进程：" + tg.isDaemon());

		MyThread mt = new MyThread(tg, "tg组的线程甲");
		mt.start();

		new MyThread(tg, "tg组的线程乙").start();
	}
}