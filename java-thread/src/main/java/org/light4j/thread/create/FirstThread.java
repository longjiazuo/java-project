package org.light4j.thread.create;

/**
 * 线程实现方式一:继承Thread类
 * 
 * @author longjiazuo
 * 
 */
public class FirstThread extends Thread {

	private int i;

	// 重写run()方法
	@Override
	public void run() {
		for (; i < 10; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 5) {
				// 创建并启动第一个线程
				new FirstThread().start();
				// 创建并启动第二个线程
				new FirstThread().start();
			}
		}
	}
}