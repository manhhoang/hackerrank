package com.jd.hackerrank.recursive_programming;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LCM_Lowest_Common_Mutiple {

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
        g = lcm(g, a[i]);
      }
      System.out.println(g);
    }
  }

  private static int lcm(int a, int b) {
    // the lcm is simply (a * b) divided by the gcd of the two
    return Math.abs(a * b) / gcd(a, b);
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }

}
