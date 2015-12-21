package com.jd.hackerrank.greedy;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PriyankaandToys {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Priyanka and Toys";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
    }
    Arrays.sort(a);
    int c = 0;
    for (int i = 0; i < N;) {
      int j = i;
      c++;
      while (j < N) {
        if (a[j] <= a[i] + 4) {
          j++;
        } else {
          break;
        }
      }
      if (i == j) {
        i++;
      } else {
        i = j;
      }
    }
    System.out.println(c);
  }

}
