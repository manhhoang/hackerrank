package com.jd.hackerrank;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Plus Minus";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    double count1 = 0;
    double count2 = 0;
    double count3 = 0;
    for (int i = 0; i < n; i++) {
      int val = sc.nextInt();
      if (val < 0) {
        count1++;
      } else if (val == 0) {
        count2++;
      } else {
        count3++;
      }
    }
    String pattern = "0.";
    for (int j = 0; j < n; j++) {
      pattern += "0";
    }
    DecimalFormat df = new DecimalFormat(pattern);
    System.out.println(df.format(count3 / n));
    System.out.println(df.format(count1 / n));
    System.out.println(df.format(count2 / n));
  }
}
