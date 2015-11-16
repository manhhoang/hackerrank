package com.jd.codility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaStream {

  public static void solution(int[] A) {
    Arrays.stream(A).forEach(System.out::print);
    System.out.println();

    System.out.println("Map and Filter:");
    Arrays.stream(A).map(n -> n * 2).filter(n -> n % 4 == 0).forEach(i -> {
      System.out.print(i + " ");
    });

    // Arrays.stream(A).flatMap((s) -> s * 3).forEach(System.out::print);
    System.out.println();
    System.out.println("Return min:");
    int min = Arrays.stream(A).reduce(Integer.MAX_VALUE, Integer::min);
    System.out.println(min);

    System.out.println("Return max:");
    int max = Arrays.stream(A).reduce(Integer.MIN_VALUE, Integer::max);
    System.out.println(max);
    // String result = Arrays.stream(A).map(s -> s * 2).collect(Collectors.joining(","));

    // List<String> list = Arrays.stream(A).map(String::valueOf).collect(Collectors.toList());

    System.out.println("Convert String to Integer:");
    String[] listString = new String[] {"1", "2", "3", "4", "5"};
    List<Integer> intList =
        Arrays.stream(listString).map(Integer::valueOf).collect(Collectors.toList());
    intList.forEach(s -> System.out.print(s + " "));

    // System.out.println("Convert int to String:");
    // List<String> re1 = Arrays.stream(A).map(String::valueOf).collect(Collectors.toList());
    // re1.forEach(s -> System.out.print(s + " "));

    System.out.println();
  }

  public static void main(String[] args) {
    int[] A = new int[] {1, 2, 3, 4, 5};
    solution(A);
  }

}
