package org.light4j.thread.synchro;

import lombok.Getter;
import lombok.Setter;

/**
 * 账户类
 * 
 * @author longjiazuo
 * 
 */
public class Account {

	@Setter
	@Getter
	// 账户编号
	private String accountNo;

	@Setter
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
}