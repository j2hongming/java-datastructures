package org.j2hongming.datastructure.sort;

/**
 * @author j2hongming
 * 每回合找到最小值放到該回合的位置
 */
public class SelectionSort {

	public void sort(int[] arr){
		// 每回合最小值的位置
		int min;
		for(int idx = 0; idx < arr.length ; idx++ ){
			min = idx;
			
			// traversal每回合最小值的位置後的序列
			for( int compareIdx = idx+1 ; compareIdx < arr.length ; compareIdx++){
				if( arr[compareIdx] < arr[min] ){
					min = compareIdx;
				}
			}
			// traversal後找到最小值
			if(idx != min){
				// swap
				int tmp = arr[idx];
				arr[idx] = arr[min];
				arr[min] = tmp;
			}
		}
	}
	
}
