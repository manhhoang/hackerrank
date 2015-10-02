package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class TheLongestCommonSubsequence {

  private static int L[][];

  private static void lcs(int[] N, int[] M, int n, int m) {
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0 || j == 0) {
          L[i][j] = 0;
        } else if (N[i - 1] == M[j - 1]) {
          L[i][j] = L[i - 1][j - 1] + 1;
        } else {
          L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
        }
      }
    }

    // Following code is used to print LCS
    int index = L[n][m];

    // Create a character array to store the lcs string
    int[] lcs = new int[index];
    // lcs[index] = '\0'; // Set the terminating character

    // Start from the right-most-bottom-most corner and
    // one by one store characters in lcs[]
    int i = m, j = n;
    while (i > 0 && j > 0) {
      // If current character in X[] and Y are same, then
      // current character is part of LCS
      if (N[i - 1] == M[j - 1]) {
        lcs[index - 1] = N[i - 1]; // Put current character in result
        i--;
        j--;
        index--; // reduce values of i, j and index
      }

      // If not same, then find the larger of two and
      // go in the direction of larger value
      else if (L[i - 1][j] > L[i][j - 1])
        i--;
      else
        j--;
    }

    // Print the lcs
    System.out.println("LCS of " + N + " and " + M + " is " + lcs);
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/The Longest Common Subsequence";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] N = new int[n];
    int[] M = new int[m];
    int i = 0;
    for (i = 0; i < n; i++) {
      N[i] = sc.nextInt();
    }

    for (i = 0; i < m; i++) {
      M[i] = sc.nextInt();
    }

    L = new int[n][m];
    lcs(N, M, n - 1, m - 1);
  }
}
