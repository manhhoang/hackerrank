package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ProjectEuler1 {
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Project Euler 1";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int k = 0; k < t; k++) {
      long n = sc.nextLong();
      BigInteger total1 = null;
      long numberOfThree = 0;
      for (long i = n - 1; i >= n - 4; i--) {
        if (i % 3 == 0) {
          numberOfThree = i;
          long number = i / 3 + 1;
          total1 = BigInteger.valueOf(number * i / 2);
          break;
        }
      }
      BigInteger total2 = null;
      long a = n - 6;
      for (long j = n - 1; j >= a; j--) {
        if (j % 5 == 0 && j != numberOfThree) {
          long number = j / 5 + 1;
          total2 = BigInteger.valueOf(number * j / 2);
        }
        a -= 5;
      }
      BigInteger ans = total1.add(total2);
      System.out.println(ans.toString());
    }
  }
}
