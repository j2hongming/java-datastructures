package org.j2hongming.datastructure.sort;

import org.j2hongming.datastructure.util.RandomArrayFactory;

public class InternalSortApp {

	public static void main(String[] args) {

		RandomArrayFactory factory = new RandomArrayFactory(50);
		
		// Insertion Sort
		int arr[] = {5, 3, 1, 2, 6, 4};
		InsertionSort insertionSortApp = new InsertionSort();
		System.out.println("Original:");
		show(arr);
		System.out.println();
		
		insertionSortApp.sort(arr);
		
		System.out.println("After Insertion Sort:");
		show(arr);
		
		// Quick Sort
		int arr2[] = {9, 4, 1, 6, 7, 3, 8, 2, 5};
		QuickSort quickSortApp = new QuickSort();
		System.out.println();
		System.out.println("Original:");
		show(arr2);
		System.out.println();
		
		quickSortApp.sort(arr2, 0, arr2.length-1);
		System.out.println("After Quick Sort:");
		show(arr2);
		
		// Selection Sort
		int arr3[] = {5, 3, 1, 6, 7, 4, 2, 8, 9};
		SelectionSort selectionSortApp = new SelectionSort();
		System.out.println();
		System.out.println("Original:");
		show(arr3);
		System.out.println();
		
		selectionSortApp.sort(arr3);
		
		System.out.println("After Selection Sort:");
		show(arr3);
		
		// Bubble Sort
		int arr4[] = {9, 1, 5, 8, 3, 7, 4, 6, 2};
		BubbleSort bubbleSortApp = new BubbleSort();
		System.out.println();
		System.out.println("Original:");
		show(arr4);
		System.out.println();
		
		bubbleSortApp.sort(arr4);
		
		System.out.println("After Bubble Sort:");
		show(arr4);
		
		int arr5[] = {2, 1, 3, 4, 5, 6, 7, 8, 9};
		System.out.println();
		System.out.println("Original:");
		show(arr5);
		System.out.println();
		
		bubbleSortApp.sortFix(arr5);
		
		System.out.println("After Fix Bubble Sort:");
		show(arr5);
		
		
		// Heap Sort
		int arr6[] = {90, 10, 50, 80, 30, 70, 40, 60, 20};
		HeapSort heapSortApp = new HeapSort();
		System.out.println();
		System.out.println("Original:");
		show(arr6);
		System.out.println();
		
		heapSortApp.sort(arr6);
		
		System.out.println("After Heap Sort:");
		show(arr6);
		
		// Merge Sort
		int arr7[] = {5, 3, 8, 6, 2, 7, 1, 4};
		MergeSort mergeSortApp = new MergeSort();
		System.out.println();
		System.out.println("Original:");
		show(arr7);
		System.out.println();
		
		mergeSortApp.sort(arr7);
		
		System.out.println("After Merge Sort:");
		show(arr7);
		
		int arr8[] = {5, 3, 8, 6, 2, 7, 1, 4};
		System.out.println();
		System.out.println("Original:");
		show(arr8);
		System.out.println("After Sleep Sort:");
        for (int val : arr8) {
            Thread thread = new Thread(new SleepSort(val));
            thread.setName("Thread "+ val);
            thread.start();
        }
	}

	public static void show(int[] arr){
		for(int e : arr){
			System.out.print(e+" ");
		}
	}
}
