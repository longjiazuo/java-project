package org.light4j.Enum.attribute;

public class GenderTest {
	public static void main(String[] args) {
		Gender g = Enum.valueOf(Gender.class, "FEMALE");
		//g.setName("女");
		System.out.println(g + "代表:" + g.getName());
		// 此时设置name值时将会提示参数错误。
		//g.setName("男");
		System.out.println(g + "代表:" + g.getName());
	}
}
