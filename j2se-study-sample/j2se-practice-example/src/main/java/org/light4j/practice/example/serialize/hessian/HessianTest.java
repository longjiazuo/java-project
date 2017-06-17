package org.light4j.practice.example.serialize.hessian;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * Hessian序列化
 * 
 * @author longjiazuo
 *
 */
public class HessianTest {
	public static void main(String[] args) {
		write("hessian.txt");
		read("hessian.txt");
	}
	
public static void write(String file){
		
		try
		(
				FileOutputStream fos = new FileOutputStream(file);
		)
		{
			Person person = new Person();
			person.setName("longjiazuo");
			person.setAge(30);
			person.setAddress("beijing");
			
			HessianOutput ho = new HessianOutput(fos);
			ho.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(String file){
		
		try
		(
				FileInputStream fis= new FileInputStream(file);
		)
		{
			HessianInput hi = new HessianInput(fis);
			Person person = (Person) hi.readObject();
			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}