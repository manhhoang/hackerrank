package com.jd.codility.prefix_sums;

import org.junit.Assert;
import org.junit.Test;

public class PassingCars {

  public int solution(int[] A) {
    int numOfZero = 0;
    int ans = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0) {
        numOfZero++;
      } else {
        ans += numOfZero;
      }
      if (ans > 1000000000) {
        return -1;
      }
    }
    return ans;
  }

  @Test
  public void test1() {
    int[] A = new int[] {0, 1, 0, 1, 1};
    Assert.assertEquals(5, solution(A));
  }

}
