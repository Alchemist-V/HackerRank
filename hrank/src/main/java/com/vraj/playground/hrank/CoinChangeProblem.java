/**
 * 
 */
package com.vraj.playground.hrank;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * https://www.hackerrank.com/challenges/coin-change/problem
 * 
 * @author vrajori
 *
 */
public class CoinChangeProblem {

	public static long variationCount = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int cost[] = new int[51];
		int N = in.nextInt();
		int m = in.nextInt();
		for (int k = 0; k < m; k++) {
			cost[k] = in.nextInt();
		}
		long combinations[] = new long[N + 1];
		combinations[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= combinations.length - 1; j++) {
				if (j >= cost[i]) {
					combinations[j] = combinations[j] + combinations[j - cost[i]];
				}
			}
		}

		System.out.print(combinations[N]);
	}
}
