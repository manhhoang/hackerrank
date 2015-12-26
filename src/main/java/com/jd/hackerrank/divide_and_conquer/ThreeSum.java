// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
// unique triplets in the array which gives the sum of zero.

package com.jd.hackerrank.divide_and_conquer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ThreeSum {

  private static class Index implements Comparable<Index> {
    public Index(int val, int pos) {
      this.val = val;
      this.pos = pos;
    }

    public int val;
    public int pos;

    @Override
    public int compareTo(Index o) {
      return this.val - o.val;
    }
  }

  public static int[] solve(int[] a) {
    int len = a.length;
    Index[] index = new Index[len];
    for (int i = 0; i < len; i++) {
      index[i] = new Index(a[i], i + 1);
    }
    Arrays.sort(index);
    int[] ans = new int[3];
    for (int i = 0; i < len - 1; i++) {
      int lo = i + 1;
      int hi = len - 1;
      while (lo < hi) {
        int sum = index[i].val + index[lo].val + index[hi].val;
        if (sum < 0) {
          lo++;
        } else if (sum > 0) {
          hi--;
        } else {
          ans[0] = index[i].pos;
          ans[1] = index[lo].pos;
          ans[2] = index[hi].pos;
          Arrays.sort(ans);
          return ans;
        }
      }
    }
    return new int[0];
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new int[] {1, 2, 3}, solve(new int[] {1, 2, -3, 4}));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new int[] {1, 2, 4}, solve(new int[] {0, 1, -3, -1}));
  }

  @Test
  public void test3() {
    Assert.assertArrayEquals(new int[] {1, 2, 3}, solve(new int[] {-2, -1, 3, 7}));
  }

}
