package com.jd.codility;

import java.util.Arrays;

public class FindSingularNumber {

  public static int solution(int[] A) {
    int N = A.length;
    Arrays.sort(A);
    for (int i = 0; i < N;) {
      int j = i;
      while (j < N && A[i] == A[j]) {
        j++;
      }
      if (j - i == 1) {
        return A[i];
      }
      i = j;
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[5];
    A[0] = 5;
    A[1] = 5;
    A[2] = 9;
    A[3] = 9;
    A[4] = 8;
    int ans = solution(A);
    System.out.println(ans);
  }
}
