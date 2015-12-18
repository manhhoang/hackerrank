package com.jd.hackerrank.string;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TheLoveLetterMystery {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/The Love-Letter Mystery";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < N; i++) {
      String s = sc.nextLine();
      int l = 0;
      int r = s.length() - 1;
      int c = 0;
      while (l <= r) {
        int ln = (int) s.charAt(l);
        int rn = (int) s.charAt(r);
        if (ln != rn) {
          c += Math.abs(rn - ln);
        }
        l++;
        r--;
      }
      System.out.println(c);
    }
  }

}
