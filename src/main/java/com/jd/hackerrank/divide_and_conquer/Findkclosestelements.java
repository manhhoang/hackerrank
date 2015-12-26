// Given a sorted array arr[] and a value X, find the k closest elements to X in arr[].
// Examples:
//
// Input: K = 4, X = 35
// arr[] = {12, 16, 22, 30, 35, 39, 42,
// 45, 48, 50, 53, 55, 56}
// Output: 30 39 42 45
package com.jd.hackerrank.divide_and_conquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Findkclosestelements {

  public static Object[] solve(int[] a, int K, int X) {
    Arrays.sort(a);
    int l = Arrays.binarySearch(a, X);
    int r = l + 1;
    if (l > 0) {
      l -= 1;
    }
    List<Integer> arr = new ArrayList<>();
    while (K > 0) {
      if (X - a[l] < a[r] - X && l > 0) {
        arr.add(a[l]);
        l--;
      } else if (X - a[l] > a[r] - X && r < a.length - 1 || l == 0) {
        arr.add(a[r]);
        r++;
      } else {
        arr.add(a[l]);
        r++;
        l--;
      }
      K--;
    }
    Collections.sort(arr);
    return arr.toArray();
  }

  @Test
  public void test1() {
    Assert.assertArrayEquals(new Object[] {30, 39, 42, 45}, solve(new int[] {
        12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56}, 4, 35));
  }

  @Test
  public void test2() {
    Assert.assertArrayEquals(new Object[] {22, 24, 30}, solve(new int[] {12, 22, 24, 30}, 3, 12));
  }

}
