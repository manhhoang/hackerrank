package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class AlternatingCharacters {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Alternating Characters";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < t; i++) {
      String S = sc.nextLine();
      char[] chars = S.toCharArray();
      char lastChar = chars[0];
      int count = 0;
      for (int j = 1; j < chars.length; j++) {
        if (chars[j] != lastChar) {
          lastChar = chars[j];
        } else {
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
