package com.jd.codility;

public class FrogJmp {

  public static int solution(int X, int Y, int D) {
    int dis = Y - X;
    if (dis % D != 0)
      return dis / D + 1;
    else
      return dis / D;
  }

  public static void main(String[] args) throws Exception {
    int X = 1;
    int Y = 5;
    int D = 2;

    int ans = solution(X, Y, D);
    System.out.println(ans);
  }
}
