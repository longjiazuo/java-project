package org.light4j.thread.communicate;

/**
 * 线程join()方法的使用
 * 
 * @author longjiazuo
 * 
 */
public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(this.getName() + " " + i);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// 启动子线程
		new JoinThread("新线程").start();
		for (int i = 0; i < 20; i++) {
			if (i == 10) {
				JoinThread jt = new JoinThread("被join的线程");
				// 启动线程
				jt.start();
				// 调用join方法等待线程jt执行完成
				jt.join();
				System.out.println("线程jt还活着吗?" + jt.isAlive());
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}