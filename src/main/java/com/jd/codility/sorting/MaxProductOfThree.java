package com.jd.codility.sorting;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MaxProductOfThree {

  public int solution(int[] A) {
    Arrays.sort(A);
    int len = A.length;
    if (A.length >= 3) {
      if (A[0] * A[1] >= A[len - 2] * A[len - 3] && A[len - 1] >= 0)
        return A[0] * A[1] * A[len - 1];
      else if (A[0] * A[1] < A[len - 2] * A[len - 3] && A[len - 1] >= 0)
        return A[len - 2] * A[len - 3] * A[len - 1];
      else if (A[0] * A[1] >= A[len - 2] * A[len - 3] && A[len - 1] < 0)
        return A[len - 2] * A[len - 3] * A[len - 1];
    }
    return 0;
  }

  @Test
  public void test1() {
    Assert.assertEquals(60, solution(new int[] {-3, 1, 2, -2, 5, 6}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(125, solution(new int[] {-5, 5, -5, 4}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(-120, solution(new int[] {-5, -6, -4, -7, -10}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(105, solution(new int[] {4, 7, 3, 2, 1, -3, -5}));
  }
}
