package org.light4j.practice.example.sort.insert;

/**
 * 折半插入排序
 * 
 * @author longjiazuo
 * 
 */
public class BinaryInsertSort {
	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 7, 5, 4, 8, 22, 44, 4, 5, 9 };
		print(array);
		binaryInsertSort(array);
		print(array);
	}

	public static void binaryInsertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int low = 0;
			int high = i - 1;
			if (high == low) {
				if (temp < array[0]) {
					array[1] = array[0];
					array[0] = temp;
				}
			}
			while (low < high) {
				int mid = (low + high) / 2;
				if (temp >= array[mid]) {
					for (int j = high; j > mid; j--) {
						array[j + 1] = array[j];
						array[j] = temp;
					}
				} else {
					low = mid + 1;
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