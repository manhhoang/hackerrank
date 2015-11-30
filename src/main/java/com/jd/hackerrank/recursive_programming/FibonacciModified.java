package com.jd.hackerrank.recursive_programming;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

  static int count = 0;

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Fibonacci Modified";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    BigInteger a = BigInteger.valueOf(sc.nextLong());
    BigInteger b = BigInteger.valueOf(sc.nextLong());
    int n = sc.nextInt();
    fibo(a, b, n);
  }

  private static void fibo(BigInteger a, BigInteger b, int n) {
    BigInteger fibo = b.pow(2).add(a);
    count++;
    if (count < n - 2) {
      fibo(b, fibo, n);
    } else {
      System.out.println(fibo.toString());
    }
  }
}
