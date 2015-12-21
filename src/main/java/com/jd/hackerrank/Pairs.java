package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Pairs {

  public static void main(String[] args) throws IOException {
    String path = new File(".").getCanonicalPath();
    String fileName = path + "/src/Pairs";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int k = sc.nextInt();
    int[] a = new int[N];
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
    }
    Arrays.sort(a);
    int count = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        if (a[j] - a[i] == k) {
          count++;
          break;
        }
      }
    }
    System.out.println(count);
  }
}
