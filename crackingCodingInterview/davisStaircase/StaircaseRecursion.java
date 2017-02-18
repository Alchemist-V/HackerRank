package com.vikas.sample;


// IDE variant 
public class StaircaseRecursion
{
	public int climb(int n, int[] trace)
	{
		if (trace[n] != 0) {
			return trace[n];
		}
		trace[n] = climb(n - 1, trace) + climb(n - 2, trace)
				+ climb(n - 3, trace);
		return trace[n];
	}

	public static void main(String[] a)
	{
		StaircaseRecursion sr = new StaircaseRecursion();
		int[] trace = new int[40];
		trace[0] = 0;
		trace[1] = 1;
		trace[2] = 2;
		trace[3] = 4;		
		System.out.println(sr.climb(7, trace));
	}
}


//HackerRank Variant
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class Solution {
//    public static int[] trace = new int[40];
//    
//    public static void main(String[] args) {
//        
//        Solution sol = new Solution();
//        Scanner in = new Scanner(System.in);
//        trace[0] = 0;
//		trace[1] = 1;
//		trace[2] = 2;
//		trace[3] = 4;	
//        
//        int s = in.nextInt();
//        for(int a0 = 0; a0 < s; a0++){
//            int n = in.nextInt();
//            System.out.println(sol.climb(n, trace));
//        }
//    }
//    
//    public int climb(int n, int[] trace) {
//        if (trace[n] != 0) {
//			return trace[n];
//		}
//		trace[n] = climb(n - 1, trace) + climb(n - 2, trace)
//				+ climb(n - 3, trace);
//		return trace[n];
//    }   
//}
