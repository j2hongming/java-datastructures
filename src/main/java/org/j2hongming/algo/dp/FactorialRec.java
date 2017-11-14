package org.j2hongming.algo.dp;

public class FactorialRec {

	int[] table;
	boolean[] solve;
	
	public FactorialRec(int stairNum) {
		this.table = new int[stairNum+1];
		this.solve = new boolean[stairNum+1];
		for(int i = 0 ; i < this.solve.length ; i++){
			this.solve[i] = false;
		}
		this.table[0] = 1;
		this.table[1] = 1;
	}

	public static void main(String[] args) {

		int factorialNum = 5;
		FactorialRec app = new FactorialRec(factorialNum);
		System.out.println( app.genFactorialResult(5) );
	}

	public int genFactorialResult(int n){
		if(n == 0 || n == 1) return 1;
		
		if(this.solve[n]) return this.table[n];
		
		this.table[n] = n * genFactorialResult(n-1);
		this.solve[n] = true;
		return this.table[n];
	}
}
