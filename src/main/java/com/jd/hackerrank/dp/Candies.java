package com.jd.hackerrank.dp;

import java.io.File;
import java.io.IOException;
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
      if (a[i] < a[i + 1] && dp[i] >= dp[i + 1]) {
        dp[i + 1] = dp[i] + 1;
      }
    }
    return Arrays.stream(dp).sum();
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Candies";
    File file = new File(fileName);
  }

  @Test
  public void test1() {
    int[] a = new int[] {1, 2, 2};
    Assert.assertEquals(4, Candies.solve(a));
  }

  @Test
  public void test2() {
    int[] a = new int[] {1, 3, 3, 2};
    Assert.assertEquals(6, Candies.solve(a));
  }

  @Test
  public void test3() {
    int[] a = new int[] {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
    Assert.assertEquals(19, Candies.solve(a));
  }

  @Test
  public void test4() {
    int[] a = new int[] {2, 2, 2, 2};
    Assert.assertEquals(4, Candies.solve(a));
  }

  @Test
  public void test5() {
    int[] a = new int[] {1, 2, 3, 4};
    Assert.assertEquals(10, Candies.solve(a));
  }

  @Test
  public void test6() {
    int[] a = new int[] {4, 3, 2, 1};
    Assert.assertEquals(10, Candies.solve(a));
  }

  @Test
  public void test7() {
    int[] a = new int[] {2, 1, 2, 1};
    Assert.assertEquals(6, Candies.solve(a));
  }

  @Test
  public void test8() {
    int[] a = new int[] {1, 2, 1, 2};
    Assert.assertEquals(6, Candies.solve(a));
  }

  @Test
  public void test9() {
    int[] a = new int[] {1, 2};
    Assert.assertEquals(3, Candies.solve(a));
  }

  @Test
  public void test10() {
    int[] a = new int[] {1, 1};
    Assert.assertEquals(2, Candies.solve(a));
  }

  @Test
  public void test11() {
    int[] a = new int[] {1, 2, 4, 3, 2, 1};
    Assert.assertEquals(13, Candies.solve(a));
  }

}
