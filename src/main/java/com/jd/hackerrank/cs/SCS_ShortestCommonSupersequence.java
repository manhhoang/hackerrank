package com.jd.hackerrank.cs;

public class SCS_ShortestCommonSupersequence {

  private static void scs(String x, String y, int M, int N) {
    // dp[i][j] = length of SCS of x[i..M] and y[j..N]
    int[][] dp = new int[M + 1][N + 1];

    // compute length of SCS and all subproblems via dynamic programming
    for (int i = 0; i <= M; i++) {
      for (int j = 0; j <= N; j++) {
        if (i == 0 || j == 0)
          dp[i][j] = i | j;
        else if (x.charAt(i - 1) == y.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
      }
    }

    // recover SCS itself and print it to standard output
    int i = 0, j = 0;
    while (i < M && j < N) {
      if (x.charAt(i) != y.charAt(j)) {
        System.out.print(x.charAt(i));
        i++;
        j++;
      } else if (dp[i + 1][j] <= dp[i][j + 1])
        i++;
      else
        j++;
    }

  }

  public static void main(String[] args) {
    String x = "AGGTAB";
    String y = "GXTXAYB";
    int M = x.length();
    int N = y.length();
    scs(x, y, M, N);
  }

}
