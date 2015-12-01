package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Quicksort2Sorting {

  private static void exch(int[] a, int i, int j) {
    int swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  private static int partition(int[] a, int lo, int hi) {
    int pivot = a[hi];
    int i = lo; // place for swapping
    for (int j = lo; j <= hi - 1; j++) {
      if (a[j] <= pivot) {
        exch(a, i, j);
        i = i + 1;
      }
    }
    exch(a, i, hi);
    return i;
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/Quicksort 2 - Sorting";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sort(a, 0, a.length - 1);
    Arrays.stream(a).forEach((x) -> System.out.print(x + " "));
  }
}
