package com.jd.codility;

import org.junit.Assert;
import org.junit.Test;

public class BinaryGap {

  public int solution(int N) {
    String s = Integer.toString(N, 2);
    int len = s.length();
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < len;) {
      int j = i;
      int count = 0;
      while (j < len) {
        if (s.charAt(j) == '0') {
          j++;
          count++;
        } else {
          break;
        }
      }
      if (j == len && s.charAt(j - 1) == '0')
        count = 0;

      if (i == j)
        i++;
      else
        i = j;

      max = Math.max(max, count);
    }
    return max;
  }

  @Test
  public void test1() {
    Assert.assertEquals(5, solution(1041));
  }

  @Test
  public void test2() {
    Assert.assertEquals(0, solution(15));
  }

  @Test
  public void test3() {
    Assert.assertEquals(1, solution(20));
  }

  @Test
  public void test4() {
    Assert.assertEquals(0, solution(6));
  }
}
