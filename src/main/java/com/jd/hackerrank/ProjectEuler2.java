package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProjectEuler2 {

  private static long total = 0;

  private static void totalFibo(long a, long b, int n) {
    long c = a + b;
    if (c <= n) {
      if (c % 2 == 0) {
        total += c;
      }
      totalFibo(b, c, n);
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Project Euler 2";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      total = 2;
      totalFibo(1, 2, n);
      System.out.println(total);
    }
  }
}
