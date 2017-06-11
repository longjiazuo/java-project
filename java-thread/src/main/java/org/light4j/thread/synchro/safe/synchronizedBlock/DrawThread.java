package org.light4j.thread.synchro.safe.synchronizedBlock;

import org.light4j.thread.synchro.Account;

/**
 * 取钱
 * <p>
 * 利用同步代码块synchronized控制线程安全
 * 
 * @author longjiazuo
 * 
 */
public class DrawThread extends Thread {

	// 用户账户
	private Account account;
	// 希望取的钱数
	private double drawAccount;

	public DrawThread(String name, Account account, double drawAccount) {
		super(name);
		this.account = account;
		this.drawAccount = drawAccount;
	}

	@Override
	public void run() {
		synchronized (account) {
			if (account.getBalance() >= drawAccount) {
				// 吐出钞票
				System.out.println(getName() + "取钱成功，吐出钞票:" + drawAccount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 修改余额
				account.setBalance(account.getBalance() - drawAccount);
				System.out.println("\t余额为：" + account.getBalance());
			} else {
				System.out.println(getName() + "取钱失败，金额不足");
			}
		}
	}

	public static void main(String[] args) {
		// 创建账户
		Account account = new Account("123456", 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 800).start();
	}
}