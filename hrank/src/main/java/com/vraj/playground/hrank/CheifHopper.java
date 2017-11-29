package com.vraj.playground.hrank;

/**
 * https://www.hackerrank.com/challenges/chief-hopper/problem
 * 
 * @author vrajori
 *
 */
public class CheifHopper {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] heights = new int[100001];
		int[] botEnergy = new int[100001];
		botEnergy[N] = 0;
		heights[0] = 0;
		int i = 1;
		while (true) {
			try {
				heights[i] = in.nextInt();
				i++;
			} catch (Exception ex) {
				break;
			}
		}

		for (int j = N - 1; j >= 0; j--) {
			int sum = (botEnergy[j + 1] + heights[j + 1]);
			if (sum % 2 == 1) {
				sum = sum + 1;
			}
			botEnergy[j] = sum / 2;
			// System.out.println("BE at building: " + j + ", with height: " +
			// heights[j] + ", is: " + botEnergy[j] + ", "
			// + botEnergy[j + 1] + " : " + heights[j + 1]);
		}
		System.out.print(botEnergy[0]);

	}
}
