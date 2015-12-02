package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort2Sorting {

  private static void copy(ArrayList<Integer> list, int a[], int startIdx) {
    for (int num : list) {
      a[startIdx++] = num;
    }
  }

  private static int partition(int[] a, int lo, int hi) {
    int p = a[lo];
    ArrayList<Integer> leftlist = new ArrayList<Integer>();
    ArrayList<Integer> rightlist = new ArrayList<Integer>();

    for (int i = lo + 1; i <= hi; i++) {
      if (a[i] > p)
        rightlist.add(a[i]);
      else
        leftlist.add(a[i]);
    }
    copy(leftlist, a, lo);
    int ppos = leftlist.size() + lo;
    a[ppos] = p;
    copy(rightlist, a, ppos + 1);

    return lo + leftlist.size();
  }

  private static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
    for (int i = lo; i <= hi; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
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
  }
}
