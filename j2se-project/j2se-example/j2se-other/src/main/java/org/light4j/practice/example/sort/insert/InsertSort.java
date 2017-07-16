package org.light4j.practice.example.sort.insert;

/**
 * 直接插入排序
 * 
 * @author longjiazuo
 * 
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 7, 5, 4, 8, 22, 44, 4, 5, 9 };
		print(array);
		System.out.println("排序后");
		sort(array);
		print(array);
	}

	public static void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (int j = i - 1; j > -1 && temp < array[j]; j--) {
				array[j + 1] = array[j];
				array[j] = temp;
			}
		}
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + " ");
			} else {
				System.out.print(array[i] + " ");
			}
		}
	}
}