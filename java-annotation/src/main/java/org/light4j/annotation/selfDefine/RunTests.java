package org.light4j.annotation.selfDefine;

public class RunTests
{
	public static void main(String[] args)
		throws Exception
	{
		// 处理MyTest类
		ProcessorTest.process("org.light4j.annotation.selfDefine.MyTest");
	}
}

