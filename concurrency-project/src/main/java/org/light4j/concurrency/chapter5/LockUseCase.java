package org.light4j.concurrency.chapter5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 10-1
 */
public class LockUseCase {
	public void lock() {
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		System.out.println(65536 * 2 & 65535);
		System.out.println(65536 >>> 16);
		System.out.println(1 << 16);
	}
}