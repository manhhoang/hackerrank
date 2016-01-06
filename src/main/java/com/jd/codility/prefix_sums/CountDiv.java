package com.jd.codility.prefix_sums;

import org.junit.Assert;
import org.junit.Test;

public class CountDiv {

  public int solution(int A, int B, int K) {
    int lo = 0;
    if (A % K == 0)
      lo = A / K;
    else
      lo = A / K + 1;

    int hi = B / K;

    if (hi > lo)
      return hi - lo + 1;
    else if (hi == lo)
      return 1;
    else
      return 0;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution(6, 11, 2));
  }

  @Test
  public void test2() {
    Assert.assertEquals(1, solution(0, 0, 11));
  }

  @Test
  public void test3() {
    Assert.assertEquals(0, solution(1, 1, 11));
  }

  @Test
  public void test4() {
    Assert.assertEquals(1, solution(10, 10, 5));
  }

  @Test
  public void test5() {
    Assert.assertEquals(0, solution(10, 10, 7));
  }
}
