package org.light4j.exception;

public class TestException2 {
	// catch 后续处理工作
	public static boolean catchMethod() {
		System.out.print("call catchMethod and return  --->>  ");
		return false;
	}

	// finally后续处理工作
	public static void finallyMethod() {
		System.out.println();
		System.out.print("call finallyMethod and do something  --->>  ");
	}

	/**
	 * 1. 抛出 Exception，没有 finally，当 catch 遇上 return
	 * 
	 * @return
	 */
	public static boolean catchTest() {
		try {
			int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
			System.out.println("i vaule is : " + i);
			return true; // Exception 已经抛出，没有获得被执行的机会
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception 抛出，获得了调用方法并返回方法值的机会
		}
	}

	/**
	 * 2. 抛出 Exception，当 catch 体里有 return，finally 体的代码块将在 catch 执行 return 之前被执行
	 * 
	 * @return
	 */
	public static boolean catchFinallyTest1() {
		try {
			int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
			System.out.println("i vaule is : " + i);
			return true; // Exception 已经抛出，没有获得被执行的机会
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod(); // Exception 抛出，获得了调用方法的机会，但方法值在 finally
									// 执行完后才返回
		} finally {
			finallyMethod(); // Exception 抛出，finally 代码块将在 catch 执行 return 之前被执行
		}
	}

	/**
	 * 3. 不抛 Exception，当 finally 代码块里面遇上 return，finally 执行完后将结束整个方法
	 * 
	 * @return
	 */
	public static boolean catchFinallyTest2() {
		try {
			int i = 10 / 2; // 不抛出 Exception
			System.out.println("i vaule is : " + i);
			return true; // 获得被执行的机会，但执行需要在 finally 执行完成之后才能被执行
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return catchMethod();
		} finally {
			finallyMethod();
			return false; // finally 中含有 return 语句，这个 return 将结束这个方法，不会在执行完之后再跳回
							// try 或 catch 继续执行，方法到此结束，返回 false
		}
	}

	/**
	 * 4. 不抛 Exception，当 finally 代码块里面遇上 System.exit() 方法 将结束和终止整个程序，而不只是方法
	 * 
	 * @return
	 */
	public static boolean finallyExitTest() {
		try {
			int i = 10 / 2; // 不抛出 Exception
			System.out.println("i vaule is : " + i);
			return true; // 获得被执行的机会，但由于 finally 已经终止程序，返回值没有机会被返回
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return true;
		} finally {
			finallyMethod();
			System.exit(0);// finally 中含有 System.exit() 语句，System.exit()
							// 将退出整个程序，程序将被终止
		}
	}

	/**
	 * 5. 抛出 Exception，当 catch 和 finally 同时遇上 return，catch 的 return
	 * 返回值将不会被返回，finally 的 return 语句将结束整个方法并返回
	 * 
	 * @return
	 */
	public static boolean finallyTest1() {
		try {
			int i = 10 / 0; // 抛出 Exception，后续处理被拒绝
			System.out.println("i vaule is : " + i);
			return true; // Exception 已经抛出，没有获得被执行的机会
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return true; // Exception 已经抛出，获得被执行的机会，但返回操作将被 finally 截断
		} finally {
			finallyMethod();
			return false; // return 将结束整个方法，返回 false
		}
	}

	/**
	 * 6. 不抛出 Exception，当 finally 遇上 return，try 的 return 返回值将不会被返回，finally 的
	 * return 语句将结束整个方法并返回
	 * 
	 * @return
	 */
	public static boolean finallyTest2() {
		try {
			int i = 10 / 2; // 不抛出 Exception
			System.out.println("i vaule is : " + i);
			return true; // 获得被执行的机会，但返回将被 finally 截断
		} catch (Exception e) {
			System.out.println(" -- Exception --");
			return true;
		} finally {
			finallyMethod();
			return false; // return 将结束这个方法，不会在执行完之后再跳回 try 或 catch 继续执行，返回
							// false
		}
	}

	public static void main(String[] args) {
		//catchTest();
		//catchFinallyTest1();
		//catchFinallyTest2();
		//finallyExitTest();
		//finallyTest1();
		finallyTest2();
	}
}
