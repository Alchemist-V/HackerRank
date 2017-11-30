/**
 * 
 */
package com.vraj.playground.hrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/challenges/largest-permutation/problem
 * 
 * @author vrajori
 *
 */
public class MaximumPermutation {

	public static void main(String[] args) {
		MaximumPermutation maxPer = new MaximumPermutation();
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int swaps = in.nextInt();
		Map<Integer, Integer> track = new HashMap<>();
		int[] arr = new int[100001];
		int[] arr_temp = new int[100001];

		int i = 0;
		while (true) {
			try {
				arr[i] = in.nextInt();
				arr_temp[i] = arr[i];
				i++;
			} catch (Exception ex) {
				break;
			}
		}

		buildTrack(arr, N, track);
		System.out.println(track);

		for (int j = 0; j < swaps; j++) {
			// N-j largest, j smallest
			if (j > N - 1) {
				break;
			}
			int index = track.get(N - j);
			swap(arr, index, j);
			System.out.println("\n");
		}

		for (int k = 0; k < N; k++) {
			System.out.print(arr[k] + " ");
		}
	}

	private static void buildTrack(int[] arr, int n, Map<Integer, Integer> track) {
		for (int i = 0; i < n; i++) {
			// System.out.println(arr[i] + ":" + i);
			track.put(arr[i], i);
		}

	}

	public void partition(int arr[], int start, int end) {

		if (start >= end) {
			return;
		}
		int pivotElement = arr[end];
		int index = start;
		for (int i = start; i < end; i++) {
			if (arr[i] < pivotElement) {
				swap(arr, i, index);
				index++;
			}
		}
		swap(arr, index, end);
		// printArr(arr);
		partition(arr, start, index - 1);
		partition(arr, index + 1, end);
	}

	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			// System.out.print(arr[i] + ", ");
		}
		// System.out.println("");

	}

	public static void swap(int[] arr, int i, int j) {
		System.out.println("Swapping: " + arr[i] + " and " + arr[j]);
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	public void swap2(int i, int j) {
		int temp = j;
		j = i;
		i = temp;
	}
}
