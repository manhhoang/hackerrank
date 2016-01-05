package com.jd.codility;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class PermCheck {

  public int solution(int[] A) {
    Arrays.sort(A);
    int ans = 1;
    for (int i = 0; i < A.length; i++) {
      if (A[i] - 0 != i + 1) {
        ans = 0;
        break;
      }
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals(0, solution(new int[] {2}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(0, solution(new int[] {1, 2, 4}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(1, solution(new int[] {1, 2}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(0, solution(new int[] {1, 3}));
  }

  @Test
  public void test6() {
    Assert.assertEquals(1, solution(new int[] {1}));
  }
}
