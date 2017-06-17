package org.light4j.thread.synchro.safe.synchronizedMethod;

import lombok.Getter;

/**
 * 账户类
 * 
 * @author longjiazuo
 * 
 */
public class Account {

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

	public synchronized void draw(double drawAccount) {
		if (this.balance >= drawAccount) {
			// 吐出钞票
			System.out.println(Thread.currentThread().getName() + "取钱成功，吐出钞票:"
					+ drawAccount);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 修改余额
			this.balance = this.balance - drawAccount;
			System.out.println("\t余额为：" + this.balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "取钱失败，金额不足");
		}
	}
}