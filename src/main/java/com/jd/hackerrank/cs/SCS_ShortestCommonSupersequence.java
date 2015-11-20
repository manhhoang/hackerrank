package com.jd.hackerrank.cs;

public class SCS_ShortestCommonSupersequence {

  private static void scs(String x, String y, int M, int N) {
    // dp[i][j] = length of SCS of x[i..M] and y[j..N]
    int[][] dp = new int[M + 1][N + 1];

    // compute length of SCS and all subproblems via dynamic programming
    for (int i = 0; i <= M; i++) {
      for (int j = 0; j <= N; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = 0;
        else if (x.charAt(i - 1) == y.charAt(j - 1))
          dp[i][j] = 1 + dp[i - 1][j - 1];
        else
          dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    // recover SCS itself and print it to standard output
    int i = M, j = N;
    while (i > 0 && j > 0) {
      if (x.charAt(i) == y.charAt(j)) {
        System.out.print(x.charAt(i));
        i--;
        j--;
      } else if (dp[i - 1][j] <= dp[i][j - 1]) {
        i--;
      } else {
        j--;
      }
    }

  }

  public static void main(String[] args) {
    String x = "geek";
    String y = "eke";
    int M = x.length();
    int N = y.length();
    scs(x, y, M, N);
  }

}
