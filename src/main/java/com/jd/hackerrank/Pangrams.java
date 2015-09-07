package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class Pangrams {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Pangrams";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    String s = sc.nextLine().toLowerCase();
    String ret = "pangram";
    for (int i = 97; i <= 122; i++) {
      if (s.indexOf(i) == -1) {
        ret = "not pangram";
        break;
      }
    }
    System.out.println(ret);

  }
}
