package com.jd.hackerrank.greedy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LargestPermutation {

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Largest Permutation";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int K = sc.nextInt();
    int[] a = new int[N];
    int[] b = new int[N];
    int[] p = new int[N + 1];
    for (int i = 0; i < N; i++) {
      a[i] = b[i] = sc.nextInt();
      p[a[i]] = i;
    }
    int c = 0;
    Arrays.sort(b);
    for (int i = 0; i < N; i++) {
      if (a[i] < b[N - 1 - i] && c < K) {
        c++;
        System.out.print(b[N - 1 - i] + " ");
        swap(a, i, p[b[N - 1 - i]]);
      } else {
        System.out.print(a[i] + " ");
      }
    }
  }
}
