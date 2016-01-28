package com.jd.codility.arrays;

import org.junit.Assert;
import org.junit.Test;

public class CyclicRotation {

  public static int[] solution(int A[], int K) {
    int len = A.length;
    int[] ans = new int[len];
    for (int i = 0; i < len; i++) {
      ans[(i + K) % len] = A[i];
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {4, 1, 2, 3}, solution(new int[] {1, 2, 3, 4}, 1));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {3, 4, 1, 2}, solution(new int[] {1, 2, 3, 4}, 2));
  }

}
