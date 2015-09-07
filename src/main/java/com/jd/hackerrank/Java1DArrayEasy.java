package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class Java1DArrayEasy {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java 1D Array (Easy)";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    System.out.println(countNegativeSubarrays(arr));
  }

  private static int countNegativeSubarrays(int[] arr) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      int sum = arr[i];
      if (sum < 0) {
        count++;
      }
      for (int j = i + 1; j < arr.length; j++) {
        sum += arr[j];
        if (sum < 0) {
          count++;
        }
      }

    }

    return count;
  }
}
