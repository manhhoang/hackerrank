package com.jd.codility;

public class TapeEquilibrium {

  public static int solution(int[] A) {
    int total = 0;
    for (int i = 0; i < A.length; i++) {
      total += A[i];
    }
    int totalLeft = 0;
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < A.length; j++) {
      totalLeft += A[j];
      int value = Math.abs(Math.abs(total - totalLeft) - totalLeft);
      min = Math.min(min, value);
    }
    return min;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[] {1, 2, 3, 3};

    int ans = solution(A);
    System.out.println(ans);
  }
}
