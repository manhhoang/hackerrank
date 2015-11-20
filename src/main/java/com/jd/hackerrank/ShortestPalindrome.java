package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class ShortestPalindrome {

  static int palin(int i, int j, String s) {
    int count = 0;
    if (!isPalin(s, i, j)) {
      count++;
      int c = palin(++i, j, s);
      int b = palin(i, --j, s);
      count += c + b;
    }
    return count;
  }

  static boolean isPalin(String s, int i, int j) {
    while (i < j) {
      if (s.charAt(i++) != s.charAt(j--)) {
        return false;
      }
    }
    return true;
  }

  static int shortPalin(String s) {
    int i = 0;
    int j = s.length() - 1;
    return palin(i, j, s);
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Shortest Palindrome";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    String s = sc.nextLine();
    System.out.print(shortPalin(s));
  }
}
