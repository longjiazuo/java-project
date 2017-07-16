package org.light4j.practice.example.test;

import java.util.HashMap;

public class ComoputerObjectSize {
	public static void main(String[] args) {
		HashMap<Integer, Long> hash = new HashMap<>();
		long j = 0;
		for (int i = 0; i < 50; i++, j++) {
			hash.put(i, j);
		}
	}
}