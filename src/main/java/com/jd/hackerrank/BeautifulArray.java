package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class BeautifulArray {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Beautiful Array";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int l = sc.nextInt();
    int[] arr = new int[n];
    long min = 1l << 60;
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    for (int make = 0; make <= 10000; make++) {
      long needplus = 0, needminus = 0;
      for (int i = 0; i < n; i++) {
        if (arr[i] < make)
          needplus += make - arr[i];
        else
          needminus += arr[i] - make;
      }

      if (needminus > needplus)
        continue;
      long cost = k * needminus + l * (needplus - needminus);
      min = Math.min(min, cost);
    }
    System.out.println(min);
  }
}
