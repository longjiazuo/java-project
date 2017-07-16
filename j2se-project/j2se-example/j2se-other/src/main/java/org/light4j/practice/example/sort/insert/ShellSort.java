package org.light4j.practice.example.sort.insert;

/**
 * 希尔排序：分组的直接插入排序
 * 
 * @author longjiazuo
 * 
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 7, 5, 4, 8, 22, 44, 4, 5, 9 };
		print(array);
		System.out.println("排序后");
		shellSort(array);
		print(array);
	}

	public static void shellSort(int array[]) {
		for (int delta = array.length / 2; delta > 0; delta /= 2) {
			for (int i = delta; i < array.length; i++) {
				int temp = array[i];
				for (int j = i - delta; j > -1 && temp < array[j]; j -= delta) {
					array[j + delta] = array[j];
					array[j] = temp;
				}
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