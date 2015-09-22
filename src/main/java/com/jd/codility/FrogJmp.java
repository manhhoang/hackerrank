package com.jd.codility;

public class FrogJmp {

  public static int solution(int X, int Y, int D) {
    int count = 0;
    int total = X;
    while (true) {
      count++;
      total += D;
      if (Y < total) {
        break;
      }
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    int X = 10;
    int Y = 85;
    int D = 30;

    int ans = solution(X, Y, D);
    System.out.println(ans);
  }
}
