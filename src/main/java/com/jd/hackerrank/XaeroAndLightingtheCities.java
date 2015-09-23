package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class XaeroAndLightingtheCities {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Xaero And Lighting the Cities";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int[] config = new int[n + 1];
      for (int j = 1; j < n; j++) {
        config[j] = sc.nextInt();
      }
      sc.nextLine();
      boolean[] city = new boolean[n + 1];
      int count = 0;
      for (int k = 0; k < n - 1; k++) {
        String[] pair = sc.nextLine().split(" ");
        int c1 = Integer.parseInt(pair[0]);
        int c2 = Integer.parseInt(pair[1]);
        if (config[c1] == 1 || config[c2] == 1) {
          //config[c1] = true;
          //config[c2] = true;
        } else {
          config[c2] = 1;
          count++;
        }
      }
      System.out.println(count);
    }
  }
}
