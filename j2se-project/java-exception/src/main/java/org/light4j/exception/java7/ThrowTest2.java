package org.light4j.exception.java7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ThrowTest2
{
	public static void main(String[] args)
		// Java 6认为①号代码可能抛出Exception，
		// 所以此处声明抛出Exception
//		throws Exception
		// Java 7会检查①号代码可能抛出异常的实际类型，
		// 因此此处只需声明抛出FileNotFoundException即可。
		throws FileNotFoundException
	{
		try
		{
			new FileOutputStream("a.txt");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw ex;        // ①
		}
	}
}