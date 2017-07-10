package org.light4j.concurrency.chapter9;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest3 {
	static CyclicBarrier c = new CyclicBarrier(2);

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					c.await();
				} catch (InterruptedException e) {
				} catch (BrokenBarrierException e) {
				}
			}
		});
		thread.start();
		System.out.println(c.getNumberWaiting());
		thread.interrupt();
		try {
			c.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			System.out.println(c.isBroken());
		}
	}
}