package com.jd.codility;

import java.util.Arrays;

public class LambdaStream {

  public static void solution(int[] A) {
    Arrays.stream(A).map(n -> n * 2).filter(n -> n % 2 == 0).forEach(s -> {
      String re = "";
      re += " " + s;
      System.out.print(re);
    });

    System.out.println();

    Arrays.stream(A).forEach(System.out::print);
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 2, 3, 4, 5};
    solution(A);
  }

}
