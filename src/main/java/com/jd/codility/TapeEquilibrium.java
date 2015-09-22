package com.jd.codility;

public class TapeEquilibrium {

  public static int solution(int[] A) {
    int total = 0;
    for (int i = 0; i < A.length; i++) {
      total += A[i];
    }
    int totalLeft = 0;
    for (int j = 0; j < A.length; j++) {
      totalLeft += A[j];
      if (2 * totalLeft > total) {
        return Math.abs(total - 2 * (totalLeft - A[j]));
      }
    }
    return 0;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[5];
    A[0] = 3;
    A[1] = 1;
    A[2] = 2;
    A[3] = 4;
    A[4] = 3;

    int ans = solution(A);
    System.out.println(ans);
  }
}
