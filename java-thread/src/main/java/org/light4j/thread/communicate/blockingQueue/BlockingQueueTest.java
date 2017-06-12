package org.light4j.thread.communicate.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * BlockingQueue阻塞队列测试
 * 
 * @author longjiazuo
 * 
 */
public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(2);// 数组队列
		//BlockingQueue<String> bq = new LinkedBlockingQueue<String>(2);//链式队列
		PriorityBlockingQueue<String> pq = new PriorityBlockingQueue<String>();
		SynchronousQueue<String> sq= new SynchronousQueue<String>();
		DelayQueue<Delayed> dq = new DelayQueue<Delayed>();
		pq.put("A");
		bq.put("java");
		bq.put("c");
		// 由于队列的容量是2，下面的执行被阻塞
		bq.put("js");
		System.out.println(bq.element());
	}
}