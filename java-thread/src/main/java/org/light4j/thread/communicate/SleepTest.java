package org.light4j.thread.communicate;

import java.util.Date;

/**
 * 线程sleep()使用测试
 * 
 * @author longjiazuo
 * 
 */
public class SleepTest {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			System.out.println("系统当前时间是;" + new Date());
			Thread.sleep(1000);
		}
	}
}
