package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EmaSupercomputer {

  private static int findOther(String[][] a, boolean[][] v, int n, int m) {
    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j].equals("G") && !v[i][j]) {
          int c = 1;
          int k = 0;
          while (true) {
            if (j + k < m && a[i][j + k].equals("G") && !v[i][j + k] && i - k >= 0
                && a[i - k][j].equals("G") && !v[i - k][j] && j - k >= 0 && a[i][j - k].equals("G")
                && !v[i][j - k] && i + k < n && a[i + k][j].equals("G") && !v[i + k][j]) {
              if (k > 0)
                c += 4;
            } else {
              break;
            }
            k++;
          }
          max = Math.max(max, c);
        }
      }
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Ema's Supercomputer";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    sc.nextLine();
    String[][] a = new String[n][m];
    for (int i = 0; i < n; i++) {
      String l = sc.nextLine();
      for (int j = 0; j < m; j++) {
        a[i][j] = l.substring(j, j + 1);
      }
    }
    int maxP = 0;
    boolean[][] v = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        v = new boolean[n][m];
        if (a[i][j].equals("G")) {
          int c = 1;
          int k = 0;
          while (true) {
            v = new boolean[n][m];
            if (j + k < m && a[i][j + k].equals("G") && i - k >= 0 && a[i - k][j].equals("G")
                && j - k >= 0 && a[i][j - k].equals("G") && i + k < n && a[i + k][j].equals("G")) {
              if (k > 0)
                c += 4;
              int f = k;
              v[i][j] = true;
              while (f > 0) {
                v[i][j + f] = true;
                v[i - f][j] = true;
                v[i][j - f] = true;
                v[i + f][j] = true;
                f--;
              }
              int other = findOther(a, v, n, m);
              maxP = Math.max(maxP, c * other);
            } else {
              break;
            }
            k++;
          }
        }
      }
    }
    System.out.println(maxP);
  }
}
