package com.jd.hackerrank.dp;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class Candies {

  public static int solve(int[] a) {
    int N = a.length;
    int[] dp = new int[N];
    for (int i = 0; i < N; i++) {
      dp[i] = 1;
    }
    for (int i = N - 1; i > 0; i--) {
      if (a[i - 1] > a[i]) {
        dp[i - 1] = dp[i] + 1;
      }
    }

    for (int i = 0; i < N - 1; i++) {
      if (a[i] < a[i + 1]) {
        dp[i + 1] = dp[i] + 1;
      } else if (a[i] == a[i + 1]) {
        if (dp[i + 1] != 1 && dp[i] < dp[i + 1]) {
          dp[i + 1] = dp[i + 1] + 1;
        } else if (dp[i + 1] != 1 && dp[i] >= dp[i + 1]) {
          dp[i + 1] = dp[i] + 1;
        }
      }
    }
    return Arrays.stream(dp).sum();
  }

  @Test
  public void test1() {
    int[] a = new int[] {1, 2, 2};
    Assert.assertEquals(4, Candies.solve(a));
  }

  @Test
  public void test2() {
    int[] a = new int[] {1, 3, 3, 2};
    Assert.assertEquals(7, Candies.solve(a));
  }

  @Test
  public void test3() {
    int[] a = new int[] {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
    Assert.assertEquals(19, Candies.solve(a));
  }

}
