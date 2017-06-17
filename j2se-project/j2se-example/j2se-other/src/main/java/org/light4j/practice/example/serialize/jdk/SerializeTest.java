package org.light4j.practice.example.serialize.jdk;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.light4j.practice.example.serialize.kryo.Person;

public class SerializeTest {
	public static void main(String[] args) {
		write("jdk.txt");
		read("jdk.txt");
	}

	public static void write(String file){
		
		try
		(
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
						file));
		)
		{
			Person person = new Person();
			person.setName("longjiazuo");
			person.setAge(30);
			person.setAddress("beijing");
			oos.writeObject(person);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void read(String file){
		
		try
		(
				ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file));
		)
		{
			Person person = (Person) ois.readObject();
			System.out.println(person);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}