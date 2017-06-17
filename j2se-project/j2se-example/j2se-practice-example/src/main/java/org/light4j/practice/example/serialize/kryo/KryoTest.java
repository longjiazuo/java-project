package org.light4j.practice.example.serialize.kryo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoTest {
	public static void main(String[] args) throws FileNotFoundException {
		// write("kryo.txt");//序列化
		read("kryo.txt");// 反序列化
	}

	public static void write(String file) throws FileNotFoundException {
		Kryo kryo = new Kryo();
		Output output = new Output(new FileOutputStream(file));
		Person person = new Person();
		person.setName("longjiazuo");
		person.setAge(30);
		person.setAddress("beijing");
		kryo.writeObject(output, person);
		output.close();
	}

	public static void read(String file) throws FileNotFoundException {
		Kryo kryo = new Kryo();
		Input input = new Input(new FileInputStream(file));
		Person person = kryo.readObject(input, Person.class);
		System.out.println(person);
		input.close();
	}
}