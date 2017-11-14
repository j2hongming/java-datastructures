package org.j2hongming.datastructure.sort;


/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/comparison-sort-insertion-sortcha-ru-pai-xu-fa.html
 * 找到最合適的位置insert
 * 如何找到最合適的位置? 透過和前面已排列元素逐一做比較，有可能造成前面已排列元素的移動
 */
public class InsertionSort {

	public void sort(int[] arr){
		// 準備insert到前面已排序好序列的值
		int key;
		for( int currentIdx = 1 ; currentIdx < arr.length ; currentIdx++){
			key = arr[currentIdx];
			// 準備insert到前面已排序好序列的值的前一個值
			int compareIdx = currentIdx - 1;
			
			// 移動所需移動的元素
			while( compareIdx >= 0 && key < arr[compareIdx] ){
				arr[compareIdx+1] = arr[compareIdx];
				compareIdx--;
			}
			
			// When key > arr[compareIdx]
			// insert到合適的位置
			arr[compareIdx+1] = key;
		}
	}
}
