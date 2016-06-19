package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TheGreatestInteger {

	public static void main(String[] args) throws IOException {
		String currentPath = new File(".").getCanonicalPath();
		String fileName = currentPath + "/src/The Greatest Integer";
		File file = new File(fileName);

		Scanner sc = new Scanner(file);
		int N = sc.nextInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int type = 0;
		Arrays.sort(a);
		boolean even;
		for (int i = 0; i < N; i++) {
			if (a[i] % 2 != 0) {
				break;
			}
		}
		int ans = a[N - 1];
		System.out.println(ans);

	}

}
