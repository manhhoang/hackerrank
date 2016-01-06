package com.jd.codility;

import junit.framework.Assert;

import org.junit.Test;

public class MaxSliceSum {

  public int solution(int A[], int N) {
    int maxSoFar = A[0];
    int maxEndingHere = A[0];

    for (int i = 1; i < A.length; i++) {
      /* calculate maxEndingHere */
      if (maxEndingHere < 0)
        maxEndingHere = A[i];
      else
        maxEndingHere += A[i];

      /* calculate maxSoFar */
      if (maxEndingHere >= maxSoFar)
        maxSoFar = maxEndingHere;
    }
    return maxSoFar;
  }

  @Test
  public void test1() {
    Assert.assertEquals(5, solution(new int[] {3, 2, -6, 4, 0}, 5));
  }
}
