package com.jd.codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class FrogRiverOne {

  static class Index implements Comparable<Index> {
    public int value;
    public int idx;

    public Index(int value, int idx) {
      this.value = value;
      this.idx = idx;
    }

    public int compareTo(Index o) {
      return this.value - o.value;
    }
  }

  public int solution(int X, int[] A) {
    List<Index> list = new ArrayList<>();
    for (int i = 0; i < A.length; i++) {
      list.add(new Index(A[i], i));
    }
    Collections.sort(list);
    int ans = -1;
    int count = 0;
    for (int i = 0; i < list.size();) {
      if (list.get(i).value <= X) {
        count++;
        int j = i;
        int min = Integer.MAX_VALUE;
        while (j < list.size()) {
          if (list.get(j).value == list.get(i).value) {
            min = Math.min(min, list.get(j).idx);
            j++;
          } else
            break;
        }
        ans = Math.max(ans, min);
        if (i == j) {
          i++;
        } else {
          i = j;
        }
      } else {
        break;
      }
    }
    if (count < X)
      ans = -1;
    return ans;
  }

  @Test
  public void test1() {
    int[] A = new int[] {5};
    Assert.assertEquals(-1, solution(5, A));
  }

  @Test
  public void test2() {
    int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    Assert.assertEquals(6, solution(5, A));
  }

  @Test
  public void test3() {
    int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    Assert.assertEquals(4, solution(3, A));
  }

  @Test
  public void test4() {
    int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    Assert.assertEquals(4, solution(4, A));
  }

  @Test
  public void test5() {
    int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    Assert.assertEquals(0, solution(1, A));
  }

  @Test
  public void test6() {
    int[] A = new int[] {1, 3, 1, 4, 2, 3, 5, 4};
    Assert.assertEquals(4, solution(2, A));
  }

}
