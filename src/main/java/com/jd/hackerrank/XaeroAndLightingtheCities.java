package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XaeroAndLightingtheCities {

  private static boolean[] config;
  private static List<Integer>[] g;
  private static int[][] d;

  private static void dfs(int v, int prev) {
    for (int w : g[v]) {
      if (w != prev) {
        dfs(w, v);
        d[0][v] += d[1][w];
        d[1][v] += Math.min(d[0][w], d[1][w]);
      }
    }

    if (!config[v]) {
      d[1][v]++;
    }
  }

  @SuppressWarnings({"resource", "unchecked"})
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Xaero And Lighting the Cities";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      g = new ArrayList[n];
      config = new boolean[n];
      for (int j = 0; j < n; j++) {
        config[j] = sc.nextInt() == 1;
        g[j] = new ArrayList<Integer>();
      }
      for (int k = 1; k < n; k++) {
        int v = sc.nextInt() - 1;
        int w = sc.nextInt() - 1;
        g[v].add(w);
        g[w].add(v);
      }
      d = new int[2][n];
      dfs(0, -1);
      System.out.println(Math.min(d[0][0], d[1][0]));
    }
  }
}
