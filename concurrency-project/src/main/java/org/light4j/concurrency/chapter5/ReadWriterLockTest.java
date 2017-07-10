package org.light4j.concurrency.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterLockTest extends Thread {
	static ReadWriteLock rw = new ReentrantReadWriteLock(true);
	static Lock read = rw.readLock();
	static Lock write = rw.writeLock();

	@Override
	public void run() {
		try {
			write.lock();
			TimeUnit.HOURS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			read.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1; i++) {
			new Thread(new ReadWriterLockTest()).start();
		}
		read.lock();
		System.out.println("main thread");
		read.unlock();
		TimeUnit.HOURS.sleep(1);
	}
}