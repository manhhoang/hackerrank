package com.jd.codility;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public static int solution1(int[] A) {
    int n = A.length;
    int result = 0;
    for (int i = 0; i < n - 1; i++) {
      if (A[i] == A[i + 1])
        result = result + 1;
    }
    int r = -1;
    for (int i = 0; i < n; i++) {
      int count = 0;
      if (i > 0) {
        if (A[i - 1] != A[i])
          count = count + 1;
        else
          count = count - 1;
      }
      if (i < n - 1) {
        if (A[i + 1] != A[i])
          count = count + 1;
        else
          count = count - 1;
      }
      r = Math.max(r, count);
    }
    return result + r;
  }

  public static int solution2(int[] A) {
    int n = A.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int dis = A[i] + A[j] + j - i;
        result = Math.max(result, dis);
      }
    }
    return result;
  }

  public static int solution(int[] A) {
    int n = A.length;
    int result = 100000;
    List<Integer> listLocations = new ArrayList<Integer>();
    for (int i = 0; i < n; i++) {
      if (!listLocations.contains(A[i])) {
        listLocations.add(A[i]);
      }
    }

    int start = 0;
    while (start < n) {
      List<Integer> templistLocations = new ArrayList<Integer>();
      templistLocations.addAll(listLocations);
      for (int i = start; i < n; i++) {
        if (templistLocations.contains(A[i])) {
          templistLocations.remove(templistLocations.indexOf(A[i]));
        }
        if (templistLocations.size() == 0) {
          result = Math.min(i - start + 1, result);
        }
      }
      start++;
    }
    return result;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[8];
    A[0] = 7;
    A[1] = 3;
    A[2] = 7;
    A[3] = 3;
    A[4] = 1;
    A[5] = 3;
    A[6] = 4;
    A[7] = 1;

    int ans = solution(A);
    System.out.println(ans);
  }
}
