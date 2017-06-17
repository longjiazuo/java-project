package org.light4j.thread.control;

/**
 * 守护线程(后台线程，精力线程)测试
 * 
 * @author longjiazuo
 * 
 */
public class DaemonThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		// 将线程设置为守护线程
		dt.setDaemon(true);
		// 启动守护线程
		dt.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}