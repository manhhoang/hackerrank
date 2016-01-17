package com.jd.codility;

import junit.framework.Assert;

import org.junit.Test;

public class Solution {

  public static int solution(int[] A) {
    int n = A.length;
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      if (A[i] == A[i + 1])
        result = result + 1;
    }
    int r = -1;
    for (int i = 0; i < n; i++) {
      int count = 0;
      if (i > 0) {
        if (A[i - 1] != A[i])
          count = count + 1;
        else
          count = count - 1;
      }
      if (i < n - 1) {
        if (A[i + 1] != A[i])
          count = count + 1;
        else
          count = count - 1;
      }
      r = Math.max(r, count);
    }
    return result + r;
  }

  @Test
  public void test1() {
    int[] A = new int[] {7, 3, 7, 3, 1, 3, 4, 1};
    int ans = solution(A);
    Assert.assertEquals(2, ans);
    System.out.println(ans);
  }
}
