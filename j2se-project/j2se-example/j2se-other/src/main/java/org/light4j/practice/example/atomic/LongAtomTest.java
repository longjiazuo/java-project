package org.light4j.practice.example.atomic;

/**
 * long类型原子性测试
 * 
 * @author longjiazuo
 * 
 */
public class LongAtomTest implements Runnable {

	private static long field = 0;

	private volatile long value;

	public LongAtomTest(long value) {
		this.setValue(value);
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 100000) {
			LongAtomTest.field = this.getValue();
			i++;
			long temp = LongAtomTest.field;
			if (temp != 1L && temp != -1L) {
				System.out.println("出现错误结果" + temp);
				System.exit(0);
			}
		}
		System.out.println("运行正确");
	}

	public static void main(String[] args) throws InterruptedException {
		// 获取并打印当前JVM是32位还是64位的
		String arch = System.getProperty("sun.arch.data.model");
		System.out.println(arch + "-bit");
		LongAtomTest t1 = new LongAtomTest(1);
		LongAtomTest t2 = new LongAtomTest(-1);
		Thread T1 = new Thread(t1);
		Thread T2 = new Thread(t2);
		T1.start();
		T2.start();
		T1.join();
		T2.join();
	}

}
