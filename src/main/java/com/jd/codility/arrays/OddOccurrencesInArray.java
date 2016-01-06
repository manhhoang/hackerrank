package com.jd.codility.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Assert;

import org.junit.Test;

public class OddOccurrencesInArray {

  public int solution(int A[]) {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = -1;
    for (int i = 0; i < A.length; i++) {
      map.merge(A[i], 1, Integer::sum);
    }
    for (Entry<Integer, Integer> entry : map.entrySet()) {
      int value = (Integer) entry.getValue();
      if (value == 1) {
        ans = (Integer) entry.getKey();
        break;
      }
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals(7, solution(new int[] {9, 3, 9, 3, 9, 7, 9}));
  }

}
