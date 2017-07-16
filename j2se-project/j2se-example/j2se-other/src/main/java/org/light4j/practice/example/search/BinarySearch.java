package org.light4j.practice.example.search;

/**
 * 二分查找(折半查找):基于已排序的数组
 * 
 * @author longjiazuo
 * 
 */
public class BinarySearch {
	final static int[] array = new int[] { 8, 17, 26, 32, 40, 72, 87, 99 };

	public static void main(String[] args) {
		System.out.println(binarySearch(array, 26, 0, array.length));
	}

	public static boolean binarySearch(int[] array, int value, int low,
			int hight) {
		while (low < hight) {
			int mid = (low + hight) / 2;
			if (value == array[mid]) {
				return true;
			} else {
				if (value < array[mid]) {
					hight = mid - 1;
				} else {
					low = mid + 1;

				}
			}
		}
		return false;
	}
}