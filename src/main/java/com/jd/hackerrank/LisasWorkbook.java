package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LisasWorkbook {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Lisa's Workbook";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    int page = 1;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < a[i]; j++) {
        if (j + 1 == page) {
          ans++;
        }
        if ((j + 1) % k == 0 || j == a[i] - 1) {
          page++;
        }
      }
    }
    System.out.println(ans);
  }

}
