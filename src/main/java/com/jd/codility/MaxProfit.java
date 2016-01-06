package com.jd.codility;

import org.junit.Assert;
import org.junit.Test;

public class MaxProfit {

  public int solution(int[] A) {
    if (A.length == 1 || A.length == 0) {
      return 0;
    }

    int maxSoFar = 0;
    int maxEndingHere = 0;
    int minPrice = A[0];

    for (int i = 1; i < A.length; i++) {
      maxEndingHere = Math.max(0, A[i] - minPrice);
      minPrice = Math.min(minPrice, A[i]);
      maxSoFar = Math.max(maxEndingHere, maxSoFar);
    }

    return maxSoFar;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(new int[] {1, 2, 3, 4}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(356, solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));
  }
}
