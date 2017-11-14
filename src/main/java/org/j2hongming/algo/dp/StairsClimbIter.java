package org.j2hongming.algo.dp;

public class StairsClimbIter {

	int[] table;
	
	public StairsClimbIter(int stairNum) {
		this.table = new int[stairNum+1];
		this.table[0] = 1;
		this.table[1] = 1;
	}

	public static void main(String[] args) {

		int stairNum = 5;
		StairsClimbIter app = new StairsClimbIter(stairNum);
		app.genClimbResult();
		System.out.println( app.table[stairNum] );
	}

	public void genClimbResult(){
		for(int i = 2 ; i < this.table.length ; i++ ){
			table[i] = table[i-1] + table[i-2];
		}
	}
}
