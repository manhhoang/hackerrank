package com.jd.hackerrank.greedy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CoinChange {

  private static int count(int S[], int m, int n) {
    int i, j, x, y;

    // We need n+1 rows as the table is consturcted in bottom up manner using
    // the base case 0 value case (n = 0)
    int[][] table = new int[n + 1][m];

    // Fill the enteries for 0 value case (n = 0)
    for (i = 0; i < m; i++)
      table[0][i] = 1;

    // Fill rest of the table enteries in bottom up manner
    for (i = 1; i < n + 1; i++) {
      for (j = 0; j < m; j++) {
        // Count of solutions including S[j]
        x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

        // Count of solutions excluding S[j]
        y = (j >= 1) ? table[i][j - 1] : 0;

        // total count
        table[i][j] = x + y;
      }
    }
    return table[n][m - 1];
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Coin Change";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    sc.nextLine();
    String line = sc.nextLine();
    String[] lines = line.split(" ");
    int[] S = new int[lines.length];
    for (int i = 0; i < S.length; i++) {
      S[i] = Integer.parseInt(lines[i]);
    }
    int ans = count(S, S.length, N);
    System.out.println(ans);
  }
}
