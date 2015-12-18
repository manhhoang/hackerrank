package com.jd.hackerrank.greedy;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Grid Challenge";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      sc.nextLine();
      String[] a = new String[N];
      for (int i = 0; i < N; i++) {
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        Arrays.sort(chars);
        String sorted = String.valueOf(chars);
        a[i] = sorted;
      }
      boolean lexi = true;
      breakLine :
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N - 1; j++) {
          if ((int) a[j].charAt(i) > (int) a[j + 1].charAt(i)) {
            lexi = false;
            break breakLine;
          }
        }
      }
      if (lexi)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
