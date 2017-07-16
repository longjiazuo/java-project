package org.light4j.practice.example.test;

import java.util.HashMap;

public class LookValue {
	public static void main(String[] args) {

		int[] array = { 4, 4, 3, 4, 3, 3, 4, 3, 3, 3, 4, 4, 4, 4, 4, 4, 6, 5,
				5, 3, 4, 5, 4, 3, 3, 4, 2, 5, 4, 4, 4, 4 };

		System.out.println(array.length);
		int value = lookValueByHashMap(array);
		System.out.println(value);
		System.out.println(lookValue(array));
	}

	public static int lookValue(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int m = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					if (++m > array.length / 2) {
						return array[i];
					}
				}
			}
		}
		return -1;
	}

	public static int lookValueByHashMap(int[] array) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (hashMap.get(array[i]) != null) {
				hashMap.put(array[i], hashMap.get(array[i]) + 1);
			} else {
				hashMap.put(array[i], 1);
			}
			if (hashMap.get(array[i]) > array.length / 2) {
				return array[i];
			}
		}
		return -1;
	}
}