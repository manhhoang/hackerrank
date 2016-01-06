package com.jd.codility.sorting;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class Distinct {

  public int solution(int[] A) {
    Arrays.sort(A);
    int count = 1;
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i + 1] != A[i]) {
        count++;
      }
    }
    if (A.length == 0)
      return 0;

    return count;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(new int[] {2, 1, 1, 2, 3, 1}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(0, solution(new int[] {}));
  }
}
