package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XaeroAndLightingtheCities {

  private static boolean[] config;
  private static List<Integer>[] g;
  private static int[][] d;

  private static void dfs(int u, int p) {
    for (int v : g[u]) {
      if (v != p) {
        dfs(v, u);
        d[0][u] += d[1][v];
        d[1][u] += Math.min(d[0][v], d[1][v]);
      }
    }

    if (!config[u]) {
      ++d[1][u];
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
        int u = sc.nextInt() - 1;
        int v = sc.nextInt() - 1;
        g[u].add(v);
        g[v].add(u);
      }
      d = new int[2][n];
      dfs(0, -1);
      System.out.println(Math.min(d[0][0], d[1][0]));
    }
  }
}
