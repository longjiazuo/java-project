package org.light4j.serialize.serializable.basicType;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 实体bean
 * 
 * @author longjiazuo
 * 
 */
public class Person implements Serializable {

	@Getter
	@Setter
	private String name;

	@Setter
	@Getter
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}