package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class DiagonalDifference {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Diagonal Difference";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);

    int n = sc.nextInt();
    sc.nextLine();
    int diff = 0;
    for (int i = 0; i < n; i++) {
      String[] row = sc.nextLine().split(" ");
      diff += Integer.parseInt(row[i]) - Integer.parseInt(row[n - i - 1]);
    }
    System.out.println(Math.abs(diff));

    // int n = sc.nextInt();
    //
    // int[] arr = new int[n * n];
    // for (int x = 0; x < n * n; x++) {
    // arr[x] = sc.nextInt();
    // }
    // sum(arr, n);
  }

  private static void sum(int[] arr, int n) {
    int sum1 = 0;
    int sum2 = 0;
    for (int y = 0; y < n; y++) {
      for (int x = 0; x < n; x++) {
        int xy = y * n + x;
        if (xy % n == y) {
          sum1 += arr[xy];
        }
        if (xy == n * (y + 1) - (y + 1)) {
          sum2 += arr[xy];
        }
      }
    }

    System.out.println(Math.abs(sum1 - sum2));
  }
}
