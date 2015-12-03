package com.jd.hackerrank.combinatorial_enumeration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TheMaximumSubarray {

  private static int maxSubCon(int[] a, int n) {
    int max = Integer.MIN_VALUE;
    int total = 0;
    for (int i = 0; i < n; i++) {
      if (total < 0) {
        total = a[i];
      } else {
        total += a[i];
      }
      max = Math.max(max, total);
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/The Maximum Subarray";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int[] a = new int[N];
      for (int i = 0; i < N; i++) {
        a[i] = sc.nextInt();
      }
      System.out.print(maxSubCon(a, a.length));
      Arrays.sort(a);
      System.out.print(" " + maxSubCon(a, a.length));
      System.out.println();
    }
  }
}
