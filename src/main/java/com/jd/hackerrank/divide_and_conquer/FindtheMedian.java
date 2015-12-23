package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindtheMedian {

  private static void exch(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static int partition(int[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;
    int p = a[lo];
    while (true) {
      while (a[++i] < p)
        if (i == hi)
          break;

      // find item on hi to swap
      while (p < a[--j])
        if (j == lo)
          break; // redundant since a[lo] acts as sentinel

      // check if pointers cross
      if (i >= j)
        break;

      exch(a, i, j);
    }

    // put partitioning item v at a[j]
    exch(a, lo, j);

    // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
    return j;

  }

  private static int findMedian(int[] a, int lo, int hi) {
    int j = partition(a, lo, hi);
    if (j == a.length / 2)
      return j;

    if (j < a.length / 2) {
      return findMedian(a, j + 1, hi);
    } else if (j > a.length / 2) {
      return findMedian(a, lo, j - 1);
    }
    return j;
  }

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/Find the Median";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
    }
    int median = findMedian(a, 0, a.length - 1);
    System.out.println(a[median]);
  }

}
