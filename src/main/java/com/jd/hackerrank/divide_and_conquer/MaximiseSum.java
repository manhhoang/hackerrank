package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MaximiseSum {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Maximise Sum";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      int[] a = new int[N];
      for (int i = 0; i < N; i++) {
        a[i] = sc.nextInt();
      }
    }
  }

}
