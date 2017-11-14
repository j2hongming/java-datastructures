package org.j2hongming.datastructure.sort;

/**
 * @author j2hongming
 * 走訪序列，氣泡由後往前透過兩兩比較互換浮現到前面
 */
public class BubbleSort {

	public void sort(int[] arr){
		
		for(int idx = 0; idx < arr.length ; idx++ ){
			
			// 由後往前到尚未被排好的element(idx)兩兩互換
			for( int compareIdx = arr.length-1 ; compareIdx > idx ; compareIdx-- ){
				
				if( arr[compareIdx] < arr[compareIdx-1] ){
					// swap
					int tmp = arr[compareIdx];
					arr[compareIdx] = arr[compareIdx-1];
					arr[compareIdx-1] = tmp;
				}
			}
		}
	}
	
	public void sortFix(int[] arr){
		
		boolean swapFlag = true;
		
		for(int idx = 0; idx < arr.length && swapFlag ; idx++ ){
			// 每回合需重置
			swapFlag = false;
			
			// 由後往前到尚未被排好的element(idx)兩兩互換
			for( int compareIdx = arr.length-1 ; compareIdx > idx ; compareIdx-- ){
				
				if( arr[compareIdx] < arr[compareIdx-1] ){
					// swap
					int tmp = arr[compareIdx];
					arr[compareIdx] = arr[compareIdx-1];
					arr[compareIdx-1] = tmp;
					swapFlag = true;
				}
			}
		}
	}
	
}
