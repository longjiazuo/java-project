package org.light4j.thread.communicate.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 利用阻塞队列 BlockingQueue模拟生产者消费者
 * 
 * @author longjiazuo
 * 
 */

// 生产者
class Producer extends Thread {
	private BlockingQueue<String> bq;

	public Producer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		String[] strArr = new String[] { "java", "struts", "spring" };
		for (int i = 0; i < 10; i++) {
			System.out.println(getName() + "生产者准备生产集合元素!");
			try {
				Thread.sleep(200);
				//尝试放入元素，如果队列已满，则阻塞
				bq.put(strArr[i % 3]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "生产完成： " + bq);
		}
	}
}

// 消费者
class Consumer extends Thread {
	private BlockingQueue<String> bq;

	public Consumer(BlockingQueue<String> bq) {
		this.bq = bq;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(getName() + "准备消费集合元素!");
			try {
				Thread.sleep(200);
				// 尝试取出元素，如果队列已空，则线程阻塞
				bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(getName() + "消费完成： " + bq);
		}
	}
}

public class ProducerConsumerTest {
	public static void main(String[] args) {
		// 创建一个容量为1的BlockingQueue
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(1);
		// 启动三个生产者线程
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		// 启动一个消费者线程
		new Consumer(bq).start();
	}
}