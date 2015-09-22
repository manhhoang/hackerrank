package com.jd.codility;

public class TapeEquilibrium {

  public static int solution(int[] A) {
    int total = 0;
    for (int i = 0; i < A.length; i++) {
      total += A[i];
    }
    int totalLeft = 0;
    int min = 0;
    for (int j = 0; j < A.length; j++) {
      totalLeft += A[j];
      int value = Math.abs(total - 2 * totalLeft);
      if (j == 0) {
        min = value;
      }
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[2];
    A[0] = 0;
    A[1] = 1;

    int ans = solution(A);
    System.out.println(ans);
  }
}
