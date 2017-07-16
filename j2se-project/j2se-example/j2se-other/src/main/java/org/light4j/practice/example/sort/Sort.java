package org.light4j.practice.example.sort;

public class Sort {
	public static void main(String[] args) {
		int[] array = new int[] { 81, 49, 76, 27, 97, 38, 49, 13, 65 };
		print(array);
		System.out.println("排序...");
		// insertSort(array);
		// binaryInsertSort(array);
		// shellSort(array, 0, array.length - 1);
		// bubbleSort(array);
		// quickSort(array, 0, array.length - 1);
		selectSort(array);
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
			int n = 0;
			while (low < high) {
				int mid = (high + low) / 2;
				if (temp == array[mid]) {
					n = mid;
					break;
				} else {
					if (temp < array[mid]) {
						high = mid - 1;
						n = high;
					} else {
						low = mid + 1;
						n = low;
					}
				}
			}

			/**
			 * 找到位置，插入元素
			 */
			for (int j = i - 1; j >= n && temp < array[j]; j--) {
				array[j + 1] = array[j];
				array[j] = temp;
			}
			print(array);
		}
	}

	/**
	 * 插入排序:希尔排序(折半的插入排序)
	 * 
	 * @param array
	 */
	public static void shellSort(int[] array, int low, int high) {
		for (int delta = (low + high) / 2; delta > 0; delta /= 2) {
			for (int i = delta; i < array.length; i++) {
				int temp = array[i];
				for (int j = i - delta; j > -1 && temp < array[j]; j -= delta) {
					array[j + delta] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	/**
	 * 交换排序:冒泡排序
	 * 
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		boolean exchange = true;
		for (int i = 1; i < array.length && exchange; i++) {
			exchange = false;
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					exchange = true;
				}
			}
		}
	}

	/**
	 * 交换排序:快速排序
	 * 
	 * @param array
	 */
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

				while (i < j && vot >= array[i]) {
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

	/**
	 * 选择排序:直接选择排序
	 * 
	 * @param array
	 */
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[min] > array[j]) {
					min = j;
				}
			}
			if (i != min) {
				int temp = array[min];
				array[min] = array[i];
				array[i] = temp;
			}
		}
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