package org.light4j.concurrency.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	private AtomicInteger atomicI = new AtomicInteger();

	private int i = 0;

	public static void main(String[] args) {
		final Counter cas = new Counter();
		List<Thread> ts = new ArrayList<>(600);
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(new Runnable() {

				@Override
				public void run() {
					cas.safeCount();
					cas.count();
				}
			});
			ts.add(t);
		}

		for (Thread t : ts) {
			t.start();
		}
		// 等待所有线程执行完成
		for (Thread t : ts) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("time:" + time + "s");
	}

	/**
	 * 使用CAS实现线程安全计数器
	 */
	private void safeCount() {
		for (;;) {
			int i = atomicI.get();
			boolean suc = atomicI.compareAndSet(i, i++);
			if (suc) {
				break;
			}
		}
	}

	/**
	 * 非线程安全计数器
	 */
	private void count() {
		i++;
	}
}