package com.jd.codility;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class MissingInteger {

  public int solution(int[] A) {
    Arrays.sort(A);
    if (A[0] > 1) {
      return 1;
    }
    for (int i = 0; i < A.length - 1; i++) {
      if (A[i] >= 0 && A[i + 1] - A[i] > 1) {
        return A[i] + 1;
      }
    }
    if (A[A.length - 1] >= 0 && A[A.length - 1] + 1 >= 0)
      return A[A.length - 1] + 1;
    else
      return 1;
  }

  @Test
  public void test1() {
    Assert.assertEquals(4, solution(new int[] {-1, 1, 2, 3}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(1, solution(new int[] {-1, -2, -2, -3}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(3, solution(new int[] {-1, 1, 2, 4}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(1, solution(new int[] {4, 5, 6, 2}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(1, solution(new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE}));
  }

}
