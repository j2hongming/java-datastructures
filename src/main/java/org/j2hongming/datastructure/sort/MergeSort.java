package org.j2hongming.datastructure.sort;

/**
 * @author
 * @see http://alrightchiu.github.io/SecondRound/comparison-sort-merge-sorthe-bing-pai-xu-fa.html
 * @see http://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 * 索引值的範圍變化
 */
public class MergeSort {

	private int[] result;
	// 用於暫存中間結果
	private int[] helper;

	private int number;

	public void sort(int[] arr) {
		this.result = arr;
		number = arr.length;
		this.helper = new int[number];
		mergeSort(0, number - 1);
	}

	private void mergeSort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergeSort(low, middle);
			// Sort the right side of the array
			mergeSort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	/**
	 * MergeSort的關鍵操作
	 * 需merge的索引值範圍，範圍最小值low，範圍最大值high，中間值middle
	 */
	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = result[i];
		}

		int rightIdx = low;
		int leftIdx = middle + 1;
		int currentIdx = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while ( rightIdx <= middle && leftIdx <= high) {
			if (helper[rightIdx] <= helper[leftIdx]) {
				result[currentIdx] = helper[rightIdx];
				rightIdx++;
			} else {
				result[currentIdx] = helper[leftIdx];
				leftIdx++;
			}
			currentIdx++;
		}
		// Copy the rest of the left side of the array into the target array
		while (rightIdx <= middle) {
			result[currentIdx] = helper[rightIdx];
			currentIdx++;
			rightIdx++;
		}

	}
}
