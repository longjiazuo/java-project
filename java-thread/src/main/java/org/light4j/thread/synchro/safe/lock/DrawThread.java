package org.light4j.thread.synchro.safe.lock;

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
		account.draw(drawAccount);
	}

	public static void main(String[] args) {
		// 创建账户
		Account account = new Account("123456", 1000);
		// 模拟两个线程对同一个账户取钱
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 800).start();
	}
}