package org.light4j.exception.exceptionStack;

public class ThreadExceptionTest implements Runnable {
	public void run() {
		firstMethod();
	}

	public void firstMethod() {
		secondMethod();
	}

	public void secondMethod() {
		int a = 5;
		int b = 0;
		int c = a / b;
	}

	public static void main(String[] args) {
		new Thread(new ThreadExceptionTest()).start();
	}
}