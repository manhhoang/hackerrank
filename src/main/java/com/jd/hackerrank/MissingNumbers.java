package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/Missing Numbers";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int[] A = new int[n];
    for (int i = 0; i < A.length; i++) {
      A[i] = sc.nextInt();
    }
    int m = sc.nextInt();
    int[] B = new int[m];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < B.length; i++) {
      B[i] = sc.nextInt();
      map.merge(B[i], 1, Integer::sum);
    }
    for (int i = 0; i < A.length; i++) {
      map.merge(A[i], -1, Integer::sum);
    }
    map.forEach((k, v) -> {
      List<Integer> list = new ArrayList<>();
      if (v > 0) {
        list.add(k);
      }
      list.stream().sorted().forEach((x) -> System.out.print(x + " "));
    });
  }
}
