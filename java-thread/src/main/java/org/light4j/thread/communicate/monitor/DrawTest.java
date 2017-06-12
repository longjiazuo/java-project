package org.light4j.thread.communicate.monitor;

/**
 * 测试
 * 
 * @author longjiazuo
 * 
 */
public class DrawTest {
	public static void main(String[] args) {
		// 创建账户
		Account account = new Account("1234567", 0);
		new DrawThread("取钱者", account, 800).start();
		new DepositThread("存钱者甲", account, 800).start();
		new DepositThread("存钱者乙", account, 800).start();
		new DepositThread("存钱者丙", account, 800).start();
	}
}
