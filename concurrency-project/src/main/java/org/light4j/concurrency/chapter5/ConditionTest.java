package org.light4j.concurrency.chapter5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Condition测试
 */
public class ConditionTest extends Thread {
	static Lock lock = new ReentrantLock(true);
	static Condition condition = lock.newCondition();

	@Override
	public void run() {
		lock.lock();
		System.out.println("thread run start");
		try {
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		System.out.println("thread run end");
	}

	public void lock() throws InterruptedException {
		TimeUnit.SECONDS.sleep(3);
		lock.lock();
		System.out.println("lock run start");
		condition.signal();
		try {
		} finally {
			lock.unlock();
		}
		System.out.println("lock run end");
	}

	public static void main(String[] args) throws InterruptedException {
		ConditionTest useCase = new ConditionTest();
		new Thread(useCase, "thread-run").start();
		useCase.lock();
	}
}