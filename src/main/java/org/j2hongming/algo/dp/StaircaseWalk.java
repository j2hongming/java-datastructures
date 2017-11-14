package org.j2hongming.algo.dp;

public class StaircaseWalk {

	int x;
	int y;
	int[][] grid;
	
	public StaircaseWalk(int x, int y) {
		this.x = x;
		this.y = y;
		// 陣列元素的預設元素為 0
		this.grid = new int[this.x][this.y];
		
		for(int xAxis = 0; xAxis < this.x ; xAxis++){
			this.grid[xAxis][0] = 1;
		}
		
		for(int yAxis = 0; yAxis < this.y ; yAxis++){
			this.grid[0][yAxis] = 1;
		}
	}

	public static void main(String[] args) {

		StaircaseWalk app = new StaircaseWalk(8, 8);
		app.genStaircaseWalkResult();
		System.out.println( app.grid[0][3] );
		System.out.println( app.grid[1][1] );
	}
	
	public void genStaircaseWalkResult(){
		for( int xAxis = 1 ; xAxis < this.x ; xAxis++ ){
			for( int yAxis = 1 ; yAxis < this.y ; yAxis++ ){
				grid[xAxis][yAxis] = grid[xAxis-1][yAxis] + grid[xAxis][yAxis-1];
			}
		}
	}

}
