package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class FunnyString {
  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Funny String";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < t; i++) {
      String S = sc.nextLine();
      char[] chars = S.toCharArray();
      int n = chars.length;
      String result = "Funny";
      for (int x = 0; x < n - 1; x++) {
        if (Math.abs((int) chars[x + 1] - (int) chars[x]) != Math.abs((int) chars[n - 2 - x]
            - (int) chars[n - 1 - x])) {
          result = "Not Funny";
          break;
        }
      }
      System.out.println(result);
    }
  }
}
