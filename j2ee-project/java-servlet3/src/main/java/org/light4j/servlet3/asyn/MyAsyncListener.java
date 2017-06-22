package org.light4j.servlet3.asyn;

import java.io.IOException;
import java.util.Date;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class MyAsyncListener implements AsyncListener {
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("------异步调用完成------" + new Date());
	}

	public void onError(AsyncEvent event) throws IOException {
	}

	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("------异步调用开始------" + new Date());
	}

	public void onTimeout(AsyncEvent event) throws IOException {
	}
}