package org.light4j.servlet3.asyn;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;

public class Executor implements Runnable {
	private AsyncContext actx = null;

	public Executor(AsyncContext actx) {
		this.actx = actx;
	}

	public void run() {
		try {
			// 等待5秒钟，以模拟业务方法的执行
			Thread.sleep(5 * 1000);
			ServletRequest request = actx.getRequest();
			List<String> books = new ArrayList<String>();
			books.add("数据结构");
			books.add("设计模式");
			books.add("编译原理");
			request.setAttribute("books", books);
			actx.dispatch("/async.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}