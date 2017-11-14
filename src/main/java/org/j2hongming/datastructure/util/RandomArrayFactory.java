package org.j2hongming.datastructure.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang.ArrayUtils;

public class RandomArrayFactory {

	int total;
	int arr[];
	
	public RandomArrayFactory(int total){
		this.setTotal(total);
		this.genRandomArray();
	}
	
	public void genRandomArray(){
		Set<Integer> set = new HashSet<Integer>();
		Random rand = new Random();
		int totalNum = this.getTotal();
		while(totalNum > 0){
		  set.add( rand.nextInt(totalNum) + 1 );
		  totalNum--;
		}
		Integer a[] = set.toArray(new Integer[set.size()]);
		this.setArr( ArrayUtils.toPrimitive(a) );
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	
}
