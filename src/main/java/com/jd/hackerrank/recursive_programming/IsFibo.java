package com.jd.hackerrank.recursive_programming;

import java.io.File;
import java.util.Scanner;

public class IsFibo {

  private static boolean isFibo = false;

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Is Fibo";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      isFibo = false;
      long inputVal = sc.nextInt();
      checkFibo(0, 1, inputVal);
      if (isFibo) {
        System.out.println("IsFibo");
      } else {
        System.out.println("IsNotFibo");
      }

    }
  }

  private static void checkFibo(long a, long b, long inputVal) {
    long fibo = a + b;
    if (fibo == inputVal) {
      isFibo = true;
    }
    if (fibo < inputVal) {
      checkFibo(b, fibo, inputVal);
    }
  }
}
