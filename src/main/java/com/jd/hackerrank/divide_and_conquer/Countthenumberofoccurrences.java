package com.jd.hackerrank.divide_and_conquer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Countthenumberofoccurrences {

  public static int solve(int[] a, int x) {
    int len = a.length;
    Arrays.sort(a);
    int l = Arrays.binarySearch(a, x);
    int c = 0;
    for (int i = l; i < len; i++) {
      if (a[i] == a[l]) {
        c++;
      } else {
        break;
      }
    }
    return c > 0 ? c : -1;
  }

  @Test
  public void test1() {
    Assert.assertEquals(4, solve(new int[] {1, 2, 2, 3, 3, 3, 3}, 3));
  }

  @Test
  public void test2() {
    Assert.assertEquals(4, solve(new int[] {1, 1, 2, 2, 2, 2, 3}, 2));
  }

  @Test
  public void test3() {
    Assert.assertEquals(1, solve(new int[] {1, 1, 2, 2, 2, 2, 3}, 3));
  }

  @Test
  public void test4() {
    Assert.assertEquals(2, solve(new int[] {1, 1, 2, 2, 2, 2, 3}, 1));
  }

  @Test
  public void test5() {
    Assert.assertEquals(-1, solve(new int[] {1, 1, 2, 2, 2, 2, 3}, 4));
  }

}
