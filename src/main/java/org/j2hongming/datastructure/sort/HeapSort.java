package org.j2hongming.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Chiu CC
 * @see http://alrightchiu.github.io/SecondRound/comparison-sort-merge-sorthe-bing-pai-xu-fa.html
 * 需注意的點是Binary tree的特性索引和程式語言陣列索引起始(0)其中的差異
 * 假設實際陣列9個元素(0 ~ 8),heapsort的部分只能做8個元素(1 ~ 8)
 */
public class HeapSort {

	/**
	 * HeapSort的關鍵操作, 調整Tree符合MaxHeap結構
	 * Recursive 方式實作
	 */
	public void maxHeapifyRec(int[] arr, int root, int length){
		int leftChild = 2 * root;
		int rightChild = 2 * root + 1;
		// root, leftChild, rightChild三者中最大的node
		int largest;
		
		// 先比較左邊
		if( leftChild <= length && arr[leftChild] > arr[root] ){
			largest = leftChild;
		}
		else{
			largest = root;
		}
		
		// 再比較右邊
		if( rightChild <= length && arr[rightChild] > arr[largest] ){
			largest = rightChild;
		}
		
		// 依照比較結果調換node
		if( largest != root ){
			// Swap
			int tmpNode = arr[root];
			arr[root] = arr[largest];
			arr[largest] = tmpNode;
			
			maxHeapifyRec(arr, largest, length);
			
		}
		
	}
	
	public void buildMaxHeap(int[] arr){
		// 針對有Child的節點，由樹的底層往上層做maxHeapify，確保在上層maxHeapify時確定底層已經符合MaxHeap的條件
		for( int hasChildIdx = arr.length / 2 ; hasChildIdx >= 1 ; hasChildIdx-- ){
			maxHeapifyRec(arr, hasChildIdx, arr.length -1 );
		}
	}
	
	public void sort(int[] arr){
		
		buildMaxHeap(arr);
		// 經過buildMaxHeap後，現在最大值在root
		
		for( int i = arr.length-1 ; i > 1 ; i-- ){
			// Swap root 和最後一個元素
			int tmpNode = arr[1];
			arr[1] = arr[i];
			arr[i] = tmpNode;
			
			// 重新調整為MaxHeap結構
			maxHeapifyRec(arr, 1, i-1 );
		}
	}
}
