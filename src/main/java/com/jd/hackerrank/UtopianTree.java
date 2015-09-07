package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class UtopianTree {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Utopian Tree";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      // n is number of cycles
      int n = sc.nextInt();
      int h = 1; // h is height of the tree
      for (int x = 1; x <= n; x++) {
        // x is cycle number
        if (x % 2 == 1) {
          h *= 2;
        } else {
          h += 1;
        }
      }
      System.out.println(h);
    }
  }
}
