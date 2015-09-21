package com.jd.hackerrank;

public class Solution {

  public static int solution(int[] A) {
    for (int i = 0; i < A.length; i++) {
      int totalLeft = 0;
      for (int j = 0; j < i; j++) {
        totalLeft += A[j];
      }
      int totalRight = 0;
      for (int k = i + 1; k < A.length; k++) {
        totalRight += A[k];
      }
      if (totalLeft == totalRight) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) throws Exception {
    // String currentPath = new File(".").getCanonicalPath();
    // String fileName = currentPath + "/src/";
    // File file = new File(fileName);

    int[] A = new int[8];
    A[0] = -1;
    A[1] = 3;
    A[2] = -4;
    A[3] = 5;
    A[4] = 1;
    A[5] = -6;
    A[6] = 2;
    A[7] = 1;

    int ans = solution(A);
    System.out.println(ans);
  }
}
