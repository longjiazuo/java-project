package org.light4j.practice.example.sort.select;

/**
 * 直接选择排序
 * 
 * @author longjiazuo
 * 
 */
public class StraightSelectSort {
	public static void main(String[] args) {
		int[] array = new int[] { 32, 38, 26, 97, 19, 66, 1, 5, 49 };
		print(array);
		straightSelectSort(array);
		print(array);
	}

	public static void straightSelectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
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