package org.light4j.thread.communicate.monitor;

public class DepositThread extends Thread {

	// 用户账户
	private Account account;
	// 存钱数
	private double depositAmount;

	public DepositThread(String name, Account account, double depositAmount) {
		super(name);
		this.account = account;
		this.depositAmount = depositAmount;
	}

	// 进行100次存钱操作
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}