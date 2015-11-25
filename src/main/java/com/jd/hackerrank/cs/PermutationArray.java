package com.jd.hackerrank.cs;

public class PermutationArray {

  private static void enumarate(int k, int[] a) {
    if (k == a.length) {
      process(a);
      return;
    }
    for (int i = k; i < a.length; i++) {
      exch(a, k, i);
      enumarate(k + 1, a);
      exch(a, i, k); // clean up
    }
  }

  private static void exch(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void process(int[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    enumarate(0, a);
  }
}
