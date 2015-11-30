package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.util.Scanner;

public class PalindromeIndex {

  static boolean isPalidrom(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Palindrome Index";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      String s = sc.next();
      int i = 0;
      int j = s.length() - 1;
      while (i < j) {
        if (s.charAt(i) != s.charAt(j)) {
          if (isPalidrom(s, i, j - 1)) {
            System.out.println(j);
          } else {
            System.out.println(i);
          }
          break;
        }
        i++;
        j--;
      }

      if (i >= j) {
        System.out.println(-1);
      }
    }
  }
}
