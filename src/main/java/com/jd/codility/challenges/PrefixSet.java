package com.jd.codility.challenges;

import junit.framework.Assert;

import org.junit.Test;

public class PrefixSet {

  public int solution(int[] A) {
    int j = 0;
    boolean[] ocur = new boolean[A.length];
    for (int i = 0; i < A.length; i++) {
      boolean val = ocur[A[i]];
      if (!val) {
        j = i;
        ocur[A[i]] = true;
      }
    }

    return j;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(new int[] {2, 2, 1, 0, 1}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(0, solution(new int[] {2, 2, 2, 2, 2}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(1, solution(new int[] {2, 1, 1, 1, 1}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(4, solution(new int[] {1, 1, 1, 1, 2}));
  }
}
