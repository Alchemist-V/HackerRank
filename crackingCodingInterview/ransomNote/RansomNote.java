package com.vikas.sample;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RansomNote
{

	public static Map<String, Integer> magazineMap = new HashMap<>();

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		String magazine[] = new String[m];
		for (int magazine_i = 0; magazine_i < m; magazine_i++) {
			magazine[magazine_i] = in.next();
			if (magazineMap.get(magazine[magazine_i].trim()) != null) {
				magazineMap.put(magazine[magazine_i].trim(),
						magazineMap.get(magazine[magazine_i].trim()) + 1);
			} else {
				magazineMap.put(magazine[magazine_i].trim(), 1);
			}

		}
		String ransom[] = new String[n];
		for (int ransom_i = 0; ransom_i < n; ransom_i++) {
			ransom[ransom_i] = in.next();
			if (magazineMap.get(ransom[ransom_i].trim()) == null
					|| magazineMap.get(ransom[ransom_i].trim()) <= 0) {
				System.out.println("No");
				return;
			} else {
				magazineMap.put(ransom[ransom_i].trim(),
						magazineMap.get(ransom[ransom_i].trim()) - 1);
			}
		}
		System.out.println("Yes");
	}
}
