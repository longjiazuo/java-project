package org.light4j.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Thread {

	int a = 0;

	ReentrantLock lock = new ReentrantLock(true);

	public void writer() throws InterruptedException {
		System.out.println("writer start:"+lock);
		lock.lock();
		try {
			Thread.sleep(7000);
			a++;
		} finally {
			lock.unlock();
		}
		System.out.println("writer end:"+lock);
	}

	public void reader() {
		System.out.println("reader start:"+lock);
		try {
			Thread.sleep(1000);
			lock.lock();
			int i = a;
			System.out.println(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		System.out.println("reader end:"+lock);
	}

	@Override
	public void run() {
		this.reader();
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockExample rte = new ReentrantLockExample();
		new Thread(rte).start();
		rte.writer();
	}
}