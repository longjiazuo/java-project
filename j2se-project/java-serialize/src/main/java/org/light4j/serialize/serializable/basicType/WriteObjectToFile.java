package org.light4j.serialize.serializable.basicType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 把对象序列化保存到文件
 * 
 * @author longjiazuo
 * 
 */
public class WriteObjectToFile {
	public static void main(String[] args) {
		try
		(
			//创建文件输出流，输出到文件object.txt
			FileOutputStream fos = new FileOutputStream("testFile\\object.txt");
			//创建对象输出流
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		)
		{
			//创建一个实体对象，并赋初值
			Person person = new Person("孙悟空",500);
			//将person对象写入到输出流
			oos.writeObject(person);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}