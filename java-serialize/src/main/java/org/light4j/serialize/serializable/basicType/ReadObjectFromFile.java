package org.light4j.serialize.serializable.basicType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 从文件反序列化生成对象
 * 
 * @author longjiazuo
 * 
 */
public class ReadObjectFromFile {
	public static void main(String[] args) {
		try
		(
			//创建文件输入流，目标文件是object.txt
			FileInputStream fis = new FileInputStream("testFile\\object.txt");
			//创建对象输入流
			ObjectInputStream ois = new ObjectInputStream(fis);
		) 
		{
			//从输入流中读取一个对象，并强转为Person类
			Person person = (Person)ois.readObject();
			//输出信息
			System.out.println("姓名:"+person.getName()+",年龄："+person.getAge());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
