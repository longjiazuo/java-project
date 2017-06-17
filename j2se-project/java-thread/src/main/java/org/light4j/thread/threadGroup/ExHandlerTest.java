package org.light4j.thread.threadGroup;

/**
 * 测试线程的异常处理
 * 
 * @author longjiazuo
 * 
 */
class MyHandler implements Thread.UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println(t + "线程出现了异常:" + e);
	}
}

public class ExHandlerTest {
	public static void main(String[] args) {
		Thread.currentThread().setDefaultUncaughtExceptionHandler(
				new MyHandler());
		int i = 5 / 0;
		System.out.println("程序正常结束!");
	}
}
