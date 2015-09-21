package com.jd.hackerrank;

public class FindOcurrence {

  public static int solution(int[] A, int X) {
    int N = A.length;
    if (N == 0) {
      return -1;
    }
    int l = 0;
    int r = N - 1;
    while (l < r) {
      int m = (l + r) / 2;
      if (A[m] > X) {
        r = m - 1;
      } else {
        l = m;
      }
    }
    if (A[l] == X) {
      return l;
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[5];
    A[0] = 1;
    A[1] = 2;
    A[2] = 5;
    A[3] = 9;
    A[4] = 9;

    int ans = solution(A, 5);
    System.out.println(ans);
  }
}
