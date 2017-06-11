package org.light4j.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 线程实现方式二:结合FutureTask和Callable
 * 
 * @author longjiazuo
 * 
 */
public class ThirdThread implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(10000);
		int i = 0;
		for (; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值："
					+ i);
		}
		// 返回值
		return i;
	}

	public static void main(String[] args) {
		ThirdThread rt = new ThirdThread();
		FutureTask<Integer> task = new FutureTask<>(rt);
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " 的循环变量i的值："
					+ i);
			if (i == 5) {
				new Thread(task, "有返回值的线程").start();
			}
		}

		try {
			System.out.println("子线程的返回值是：" + task.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
