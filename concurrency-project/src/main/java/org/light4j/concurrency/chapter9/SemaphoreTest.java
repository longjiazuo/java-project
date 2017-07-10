package org.light4j.concurrency.chapter9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore测试
 * 
 * @author longjiazuo
 * 
 */
public class SemaphoreTest {
	private static final int THREAD_COUNT = 30;

	private static ExecutorService threadPool = Executors
			.newFixedThreadPool(THREAD_COUNT);

	static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						s.acquire();
						System.out.println(s.getQueueLength());
						System.out.println("save data");
						s.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		threadPool.shutdown();
	}
}