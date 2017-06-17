package org.light4j.annotation.basic;

import java.util.Arrays;

public class ErrorUtilsTest
{
	public static void main(String[] args)
	{
		ErrorUtils.faultyMethod(Arrays.asList("Hello!")
			, Arrays.asList("World!"));
	}
}