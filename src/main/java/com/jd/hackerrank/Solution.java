package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Solution";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int C = sc.nextInt();
      int B = sc.nextInt();
      int P = sc.nextInt();
      double w = 0;
      if (C - B != 0) {
        w = 1 / ((((P / 100) - (C - B) / C) * C / (C - B)) - 1);
      } else {
        w = B * 2;
      }

      System.out.println(Math.ceil(w));
    }

  }

}
