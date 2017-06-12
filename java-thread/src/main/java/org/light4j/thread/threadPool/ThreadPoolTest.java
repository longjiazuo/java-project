package org.light4j.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池ThreadPool使用测试
 * 
 * @author longjiazuo
 * 
 */

class Mythread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "变量i的值是:" + i);
		}
	}
}

public class ThreadPoolTest {
	public static void main(String[] args) {
		ExecutorService pool=Executors.newFixedThreadPool(2);
		pool.submit(new Mythread());
		pool.submit(new Mythread());
		//关闭线程
		pool.shutdown();
	}
}