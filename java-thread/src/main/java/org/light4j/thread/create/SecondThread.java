package org.light4j.thread.create;

/**
 * 线程实现方式二:实现Runnable接口
 * 
 * @author longjiazuo
 * 
 */
public class SecondThread implements Runnable {

	private int i;

	@Override
	public void run() {
		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			SecondThread thread = new SecondThread();
			if (i == 5) {
				// 创建第一个线程并启动
				new Thread(thread).start();
				// 创建第二个线程并启动
				new Thread(thread).start();
			}
		}
	}
}