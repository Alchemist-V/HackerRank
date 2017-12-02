/**
 * 
 */
package com.vraj.playground.hrank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem
 * 
 * @author vrajori
 *
 */
public class RunningMedian {

	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(100, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2.compareTo(o1);
		}
	});

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>(100, new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1.compareTo(o2);
		}
	});

	public static double median = 0.0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		for (int i = 0; i < size; i++) {
			int entry = in.nextInt();
			calculateMedian(entry);
			// System.out.println(median + ", minHeap: " + minHeap + ", maxHeap:
			// " + maxHeap);
			System.out.println(median);
		}
	}

	private static void calculateMedian(int entry) {
		// Idea is to keep both heaps balances.
		if (maxHeap.size() == minHeap.size()) {
			if (entry > median) {
				minHeap.add(entry);
				median = minHeap.peek();
			} else {
				maxHeap.add(entry);
				median = (double) maxHeap.peek();
			}
		} else if (maxHeap.size() > minHeap.size()) {
			if (entry < median) {
				minHeap.add(maxHeap.poll());
				maxHeap.add(entry);
			} else {
				minHeap.add(entry);
			}
			median = (double) (((double) minHeap.peek() + (double) maxHeap.peek()) / 2);
		} else {
			if (entry > median) {
				maxHeap.add(minHeap.poll());
				minHeap.add(entry);
			} else {
				maxHeap.add(entry);
			}
			median = (double) (((double) minHeap.peek() + (double) maxHeap.peek()) / 2);
		}

	}

}
