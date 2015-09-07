package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class Staircase {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Staircase";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (j < n - i - 1) {
          System.out.print(" ");
        } else {
          System.out.print("#");
        }
      }
      System.out.println("");
    }
  }
}
