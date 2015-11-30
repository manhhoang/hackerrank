package com.jd.hackerrank.graph;

import java.io.File;
import java.util.Scanner;

public class HexagonalWar {

  private static int[][] g;
  private static boolean[][] visit;
  private static final int Persians = 2;
  private static final int Romans = 1;
  private static boolean persianWin;
  private static boolean romansWin;

  private static void dfs(int y, int x, int n) {
    visit[y][x] = true;
    if (y == n - 1 && g[y][x] == Persians) {
      persianWin = true;
    } else if (x == n - 1 && g[y][x] == Romans) {
      romansWin = true;
    } else {
      if (x > 0 && !visit[y][x - 1] && g[y][x - 1] == g[y][x]) { // check left
        dfs(y, x - 1, n);
      }
      if (x < n - 1 && !visit[y][x + 1] && g[y][x + 1] == g[y][x]) { // check right
        dfs(y, x + 1, n);
      }
      if (y > 0 && !visit[y - 1][x] && g[y - 1][x] == g[y][x]) { // check top
        dfs(y - 1, x, n);
      }
      if (y < n - 1 && !visit[y + 1][x] && g[y + 1][x] == g[y][x]) { // check bottom
        dfs(y + 1, x, n);
      }
      if (x < n - 1 && y > 0 && !visit[y - 1][x + 1] && g[y - 1][x + 1] == g[y][x]) { // check
                                                                                      // top-right
        dfs(y - 1, x + 1, n);
      }
      if (x > 0 && y < n - 1 && !visit[y + 1][x - 1] && g[y + 1][x - 1] == g[y][x]) { // check
                                                                                      // bottom-left
        dfs(y + 1, x - 1, n);
      }
    }

  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Hexagonal War";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    g = new int[n][n];
    visit = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      int y = sc.nextInt() - 1;
      int x = sc.nextInt() - 1;
      if (i % 2 == 0) {
        g[y][x] = 1; // Romans
      } else {
        g[y][x] = 2; // Persians
      }
    }

    for (int x = 0; x < n; x++) {
      if (g[0][x] == Persians) {
        dfs(0, x, n);
      }
    }
    for (int y = 0; y < n; y++) {
      if (g[y][0] == Romans) {
        dfs(y, 0, n);
      }
    }
    if (romansWin && persianWin) {
      System.out.println("NEITHER");
    } else if (romansWin) {
      System.out.println("ROMANS");
    } else if (persianWin) {
      System.out.println("PERSIANS");
    }
  }
}
