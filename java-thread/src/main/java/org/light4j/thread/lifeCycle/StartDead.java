package org.light4j.thread.lifeCycle;

/**
 * 启动已经死亡的线程
 * 
 * @author longjiazuo
 * 
 */
public class StartDead extends Thread {

	private int i;

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		StartDead sd = new StartDead();
		for (int i = 0; i < 300; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				sd.start();
				// 判断启动后的线程是否活着
				System.out.println("线程活着吗?" + sd.isAlive());
			}

			if (i > 20 && !sd.isAlive()) {
				System.out.println("线程已经死亡，再次启动报异常");
				//再次启动线程
				sd.start();
			}
		}
	}
}