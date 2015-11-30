package com.jd.hackerrank.recursive_programming;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GCD_Greatest_Common_Divisor {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Sherlock and GCD";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }
      int g = a[0];
      for (int i = 1; i < n; i++) {
        g = gcd(g, a[i]);
      }
      if (g == 1)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

}
