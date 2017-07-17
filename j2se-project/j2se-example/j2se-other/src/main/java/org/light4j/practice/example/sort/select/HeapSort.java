package org.light4j.practice.example.sort.select;

/**
 * 堆排序
 * 
 * @author longjiazuo
 * 
 */
public class HeapSort {
	public static void main(String[] args) {
		int[] array = new int[] { 81, 49, 76, 27, 97, 38, 49, 13, 65 };
		print(array);
		heapSort(array);
		print(array);
	}

	private static void sift(int[] array, int low, int high) {
		int i = low;// 子树的根
		int j = 2 * i + 1;// 子树的左孩子节点
		int temp = array[i];// 获得第i个元素的值
		while (j <= high) {// 沿较小值节点向下刷选
			if (j < high && array[j] > array[j + 1]) {// 数组元素比较(改成<为最大堆)
				j++;// j为左右孩子的较小者
			}
			if (temp > array[j]) {// 若父母节点值较小
				array[i] = array[j];// 孩子节点中的较小值上移
				i = j;// i,j向下一层
				j = 2 * i + 1;
			} else {
				j = high + 1;// 退出循环
			}
			array[i] = temp;
		}
	}

	public static void heapSort(int[] array) {
		int n = array.length;
		for (int j = n / 2 - 1; j >= 0; j--) {
			sift(array, j, n - 1);
		}

		for (int j = n - 1; j > 0; j--) {
			int temp = array[0];
			array[0] = array[j];
			array[j] = temp;
			sift(array, 0, j - 1);
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