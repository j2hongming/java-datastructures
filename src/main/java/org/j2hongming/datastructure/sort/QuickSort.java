package org.j2hongming.datastructure.sort;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/comparison-sort-quick-sortkuai-su-pai-xu-fa.html
 * 在數列中任意挑選一個數，稱為pivot，然後調整數列
 * 在pivot左邊的數，都比pivot小
 * 在pivot右邊的數，都比pivot大
 */
public class QuickSort {

	/**
	 * QuickSort的關鍵操作：摩西分紅海
	 * @return pivot最後的位置
	 */
	public int partition(int[] arr , int front, int end){
		// 指定最後一個元素為pivot
		int pivot = arr[end];
		// 比pivot小的序列中的最後一個位置
		int candidatePivotPosition = front - 1;
		
		for( int traversalIdx = front ; traversalIdx < end ; traversalIdx++ ){
			
			if(arr[traversalIdx] < pivot){
				candidatePivotPosition++;
				// swap
				int tmp = arr[candidatePivotPosition];
				arr[candidatePivotPosition] = arr[traversalIdx];
				arr[traversalIdx] = tmp;
			}
		}
		// Traversal Done
		candidatePivotPosition++;
		// swap
		int tmp = arr[candidatePivotPosition];
		arr[candidatePivotPosition] = arr[end];
		arr[end] = tmp;
		return candidatePivotPosition;
		
	}
	
	public void sort(int[] arr , int front, int end){
		// 終止條件
		if( front > end ){
			return;
		}
		
		int pivotPostion = partition(arr, front, end);
		sort(arr, front, pivotPostion-1);
		sort(arr, pivotPostion+1, end);
		
	}
	
}
