package org.light4j.thread.synchro.safe.lock;

import java.util.concurrent.locks.ReentrantLock;

import lombok.Getter;

/**
 * 账户类
 * 
 * @author longjiazuo
 * 
 */
public class Account {
	// 定义锁对象
	private final ReentrantLock lock = new ReentrantLock();

	@Getter
	// 账户编号
	private String accountNo;

	@Getter
	// 账户余额
	private double balance;

	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return accountNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj != null) {
			if (obj.getClass() == Account.class) {
				Account target = (Account) obj;
				return this.accountNo.equals(target.accountNo);
			}
		}
		return false;
	}

	public void draw(double drawAccount) {
		// 加锁
		lock.lock();
		try {
			if (this.balance >= drawAccount) {
				// 吐出钞票
				System.out.println(Thread.currentThread().getName()
						+ "取钱成功，吐出钞票:" + drawAccount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改余额
				this.balance = this.balance - drawAccount;
				System.out.println("\t余额为：" + this.balance);
			} else {
				System.out.println(Thread.currentThread().getName()
						+ "取钱失败，金额不足");
			}
		} finally {
			// 释放锁
			lock.unlock();
		}
	}
}