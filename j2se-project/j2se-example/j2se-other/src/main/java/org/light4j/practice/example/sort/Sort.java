package org.light4j.practice.example.sort;

public class Sort {
	public static void main(String[] args) {
		int[] array = new int[] { 81, 49, 76, 27, 97, 38, 49, 13, 65 };
		print(array);
		System.out.println("排序...");
		// insertSort(array);
		binaryInsertSort(array);
		print(array);
	}

	/**
	 * 插入排序:直接插入排序
	 * 
	 * @param array
	 */
	public static void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			for (int j = i - 1; j > -1 && temp < array[j]; j--) {
				array[j + 1] = array[j];
				array[j] = temp;
			}
		}
	}

	/**
	 * 插入排序:折半插入排序
	 * 
	 * @param array
	 */
	public static void binaryInsertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int temp = array[i];
			int low = 0;
			int high = i - 1;
			while (low < high) {
				int mid = (high + low) / 2;
				if (temp == array[mid]) {
					int j = high;
					while (j > mid) {
						array[j + 1] = array[j];
						array[j] = temp;
						j--;
					}
					break;
				} else {
					if (temp < array[mid]) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
			}

			/**
			 * low==high说明找不到相等的元素
			 */
			if (low == high) {
				for (int j = i - 1; j > -1 && temp < array[j]; j--) {
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
			print(array);
		}
	}

	/**
	 * 插入排序:希尔排序
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array) {

	}

	/**
	 * 交换排序:冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {

	}

	/**
	 * 交换排序:快速排序
	 * 
	 * @param array
	 */
	public static void quickSort(int[] array) {

	}

	/**
	 * 选择排序:直接选择排序
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {

	}

	/**
	 * 选择排序:堆排序
	 * 
	 * @param array
	 */
	public static void heapSort(int[] array) {

	}

	/**
	 * 合并排序
	 * 
	 * @param array
	 */
	public static void mergeSort(int[] array) {

	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i]);
			} else {
				System.out.print(array[i] + " ");
			}
		}
	}
}