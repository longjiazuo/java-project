package org.light4j.concurrency.chapter9;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Exchanger测试
 * 
 * @author longjiazuo
 * 
 */
public class ExchangerTest1 {
	private static final Exchanger<Change> exgr = new Exchanger<>();

	private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

	public static void main(String[] args) throws InterruptedException {
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				Change A = new Change("银行流水A");// A录入银行流水数据
				try {
					Change B = exgr.exchange(A);
					System.out.println("A:"+B.getMsg());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		TimeUnit.SECONDS.sleep(100);
		threadPool.execute(new Runnable() {

			@Override
			public void run() {
				Change B = new Change("银行流水B");// B录入银行流水数据
				try {
					Change A = exgr.exchange(B);
					System.out.println("B:"+A.getMsg());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		threadPool.shutdown();
	}

	static class Change {
		private String msg;

		public Change(String msg) {
			this.msg = msg;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}
}