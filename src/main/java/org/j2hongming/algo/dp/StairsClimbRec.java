package org.j2hongming.algo.dp;

public class StairsClimbRec {

	int[] table;
	boolean[] solve;
	
	
	
	public StairsClimbRec(int stairNum) {
		super();
		this.table = new int[stairNum+1];
		this.solve = new boolean[stairNum+1];
		for(int i = 0 ; i < this.solve.length ; i++){
			this.solve[i] = false;
		}
	}

	public static void main(String[] args) {

		int stairNum = 5;
		StairsClimbRec app = new StairsClimbRec(stairNum);
		System.out.println( app.genClimbResult(5) );
	}
	
	public int genClimbResult(int n){
		if(n == 0 || n == 1) return 1;
		
		if(this.solve[n]) return this.table[n];
		
		this.table[n] = genClimbResult(n-1) + genClimbResult(n-2);
		this.solve[n] = true;
		return this.table[n];
	}

}
