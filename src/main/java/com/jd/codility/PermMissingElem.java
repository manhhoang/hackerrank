package com.jd.codility;

import java.util.Arrays;

public class PermMissingElem {

  public static int solution(int[] A) {
    Arrays.sort(A);
    for (int i = 1; i < A.length; i++) {
      if (A[i] - A[i - 1] > 1) {
        return A[i - 1] + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[4];
    A[0] = 2;
    A[1] = 3;
    A[2] = 1;
    A[3] = 5;

    int ans = solution(A);
    System.out.println(ans);
  }
}
