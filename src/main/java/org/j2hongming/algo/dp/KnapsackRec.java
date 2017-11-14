package org.j2hongming.algo.dp;

/**
 * @author Boris Rusev
 *         http://stackoverflow.com/questions/7774769/how-do-i-solve-the-classic
 *         -knapsack-algorithm-recursively
 */
public class KnapsackRec {

//	static int[] values = new int[] { 894, 260, 392, 281, 27 };
//	static int[] weights = new int[] { 8, 6, 4, 0, 21 };
//	static int W = 30;
	static int[] values = new int[]{10, 40, 30, 50};
	static int[] weights = new int[]{5, 4, 6, 3};
	static int W = 10;
	

	private static int knapsack(int i, int W) {
		if (i < 0) {
			return 0;
		}
		if (weights[i] > W) {
			return knapsack(i - 1, W);
		} else {
			return Math.max(knapsack(i - 1, W), knapsack(i - 1, W - weights[i]) + values[i]);
		}
	}

	public static void main(String[] args) {
		System.out.println(knapsack(values.length - 1, W));
	}

}
