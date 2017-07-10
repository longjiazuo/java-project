package org.light4j.concurrency.chapter9;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchanger测试
 * 
 * @author longjiazuo
 * 
 */
public class ExchangerTest {
	private static final Exchanger<String> exgr = new Exchanger<>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				String A = "银行流水A";// A录入银行流水数据
				try {
					String B = exgr.exchange(A);
					System.out.println(B);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				String B = "银行流水B";// B录入银行流水数据
				try {
					String A = exgr.exchange(B);
					System.out.println(A);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		threadPool.shutdown();
	}
}