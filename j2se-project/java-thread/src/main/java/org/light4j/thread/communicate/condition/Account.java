package org.light4j.thread.communicate.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
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
	private final Lock lock = new ReentrantLock();
	// 获取锁对象指定的Condition对象
	private final Condition condition = lock.newCondition();

	@Getter
	// 账户编号
	private String accountNo;

	@Getter
	// 账户余额
	private double balance;

	// 标识账户中是否有存款的标识
	private boolean flag = false;

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

	/**
	 * 取钱
	 * 
	 * @param drawAccount
	 */
	public void draw(double drawAccount) {
		try {
			//加锁
			lock.lock();
			// 如果flag为true，表明账户中已经有人存钱进去，可以进行取钱操作
			if (flag) {
				if (this.balance >= drawAccount) {
					// 吐出钞票
					System.out.println(Thread.currentThread().getName()+ "取钱成功，吐出钞票:" + drawAccount);
					// 修改余额
					this.balance = this.balance - drawAccount;
					// 将flag设置为false，表示已经没钱
					flag = false;
					// 唤醒其他线程
					condition.signalAll();
					System.out.println("\t余额为：" + this.balance);
				} else {
					System.out.println(Thread.currentThread().getName()+ "取钱失败，金额不足");
				}
			} else {
				condition.await();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//解锁
			lock.unlock();
		}
	}

	/**
	 * 存钱
	 * 
	 * @param depositAmount
	 */
	public void deposit(double depositAmount) {
		try {
			//加锁
			lock.lock();
			// 如果flag为true，表明账户中已经有人存钱进去，存钱操作阻塞
			if (flag) {
				condition.await();
			} else {
				// 存入钞票
				System.out.println(Thread.currentThread().getName()+ "存钱成功，存入钞票:" + depositAmount);
				// 修改余额
				this.balance = this.balance + depositAmount;
				// 将flag设置为true，表示已经有钱
				flag = true;
				// 唤醒其他线程
				condition.signalAll();
				System.out.println("\t余额为：" + this.balance);
			}
		} catch (Exception e) {
		}finally{
			//解锁
			lock.unlock();
		}
	}
}