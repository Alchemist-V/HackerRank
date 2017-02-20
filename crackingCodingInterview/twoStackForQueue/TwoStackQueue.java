package com.vikas.sample;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TwoStackQueue
{
	public static class MyQueue<T>
	{
		Stack<T> primary = new Stack<T>();
		Stack<T> secondary = new Stack<T>();

		public void enqueue(T value)
		{
			primary.push(value);
		}

		/**
		 * The key here is to lazily create your secondary stack, i.e. recreate
		 * it again only if you it becomes empty and there is a pop/peek
		 * operation.
		 */

		public T peek()
		{
			if (secondary.empty()) {
				while (!primary.empty()) {
					secondary.push(primary.pop());
				}
			}

			return secondary.peek();
		}

		public T dequeue()
		{
			if (secondary.empty()) {
				while (!primary.empty()) {
					secondary.push(primary.pop());
				}
			}

			return secondary.pop();
		}
	}

	public static void main(String[] args)
	{
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}
