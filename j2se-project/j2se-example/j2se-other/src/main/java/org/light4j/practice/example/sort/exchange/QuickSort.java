package org.light4j.practice.example.sort.exchange;

/**
 * 快速排序
 * 
 * @author longjiazuo
 * 
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] array = new int[] { 32,38, 26, 97, 19, 66, 1, 5, 49 };
		print(array);
		quickSort(array, 0, array.length - 1);
		print(array);
	}

	public static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int i = low, j = high;
			int vot = array[i];
			while (i < j) {
				while (i < j && vot <= array[j]) {
					j--;
				}
				if (i < j) {
					array[i] = array[j];
					i++;
				}

				while (i < j & vot >= array[i]) {
					i++;
				}
				if (i < j) {
					array[j] = array[i];
					j--;
				}

				array[i] = vot;
				quickSort(array, low, i - 1);
				quickSort(array, i + 1, high);
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