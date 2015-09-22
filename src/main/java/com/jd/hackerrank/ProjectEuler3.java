package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProjectEuler3 {

  private static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Project Euler 3";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      boolean find = false;
      for (int j = n - 1; j > 1; j--) {
        if (isPrime(j)) {
          find = true;
          System.out.println(j);
          break;
        }
      }
      if (!find) {
        System.out.println(n);
      }
    }
  }
}
