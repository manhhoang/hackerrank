package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Bar_FaceBook {

  private static Set<Integer> ans = new HashSet<Integer>();

  private static void process(int K, List<Integer> output) {
    Collections.sort(output);
    ans.add(output.get(K - 2));
  }

  private static void enumarate(int d, int[][] a, int K, List<Integer> output) {
    if (d == a.length) {
      process(K, output);
      return;
    }
    for (int i = 0; i < a[d].length; i++) {
      output.add(a[d][i]);
      enumarate(d + 1, a, K, output);
      output.remove(output.size() - 1);
    }
    return;
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Bar_FaceBook";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt(); // number of person
      int K = sc.nextInt(); // Kth larget number
      int[][] a = new int[3][];
      for (int i = 0; i < N; i++) {
        int A = sc.nextInt(); // number of list for each person
        a[i] = new int[A]; // list number of each
        for (int j = 0; j < A; j++) {
          a[i][j] = sc.nextInt(); // element of list
        }
      }
      List<Integer> output = new ArrayList<>();
      enumarate(0, a, K, output);
      System.out.println(ans.size());
    }
  }
}
