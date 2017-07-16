package org.light4j.practice.example.sort.exchange;

/**
 * 冒泡排序
 * 
 * @author longjiazuo
 * 
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[] { 3, 1, 7, 5, 4, 8, 22, 44, 4, 5, 9 };
		print(array);
		bubbleSort(array);
		print(array);
	}

	public static void bubbleSort(int[] array) {
		boolean exchange = true;// 是否需要交换的标记,对排序进行优化
		for (int i = 1; i < array.length && exchange; i++) {
			exchange = false;
			for (int j = 0; j < (array.length - i) && (array[j] > array[j + 1]); j++) {
				int temp = array[j + 1];
				array[j + 1] = array[j];
				array[j] = temp;
				exchange = true;
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