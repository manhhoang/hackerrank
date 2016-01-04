package com.jd.codility;

import org.junit.Assert;
import org.junit.Test;

public class StrSymmetryPoint {

  public int solution(String S) {
    int l = 0;
    int r = S.length() - 1;
    int ans = -1;
    while (l <= r) {
      if (l == r) {
        ans = l;
        break;
      }
      if (S.charAt(l) == S.charAt(r)) {
        l++;
        r--;
      } else {
        ans = -1;
        break;
      }
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals(3, solution("racecar"));
  }

  @Test
  public void test2() {
    Assert.assertEquals(0, solution("x"));
  }

}
