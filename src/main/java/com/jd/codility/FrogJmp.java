package com.jd.codility;

public class FrogJmp {

  public static int solution(int X, int Y, int D) {
    int count = 0;
    int total = X;
    while (true) {
      total += D;
      if (Y < total) {
        break;
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    int X = 1;
    int Y = 5;
    int D = 2;

    int ans = solution(X, Y, D);
    System.out.println(ans);
  }
}
