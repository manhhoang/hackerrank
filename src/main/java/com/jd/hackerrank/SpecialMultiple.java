package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class SpecialMultiple {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Special Multiple 1";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      long x = n;

      while (true) {
        x += n;
        if (x % n == 0 && isValidNumber(x)) {
          break;
        }
      }
      System.out.println(x);
    }
  }

  private static boolean isValidNumber(long x) {
    String strX = String.valueOf(x);
    if (!strX.matches("^[09]+")) {
      return false;
    }
    return true;
  }
}
