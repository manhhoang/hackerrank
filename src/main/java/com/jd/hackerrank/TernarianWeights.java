package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TernarianWeights {
  private static boolean isPower(int n) {
    while (n != 1) {
      if (n % 3 == 0) {
        n = n / 3;
      } else {
        return false;
      }
    }
    return true;
  }

  private static List<Integer> getPowerList(int k) {
    List<Integer> re = new ArrayList<>();
    int n = k;
    int i = n;
    while (i > 1) {
      if (isPower(i)) {
        re.add(i);
        int total = re.stream().mapToInt(Integer::intValue).sum();
        if (total == k)
          return re;
        if (isPower(n - i)) {
          re.add(n - i);
          total = re.stream().mapToInt(Integer::intValue).sum();
          if (total == k)
            return re;
        } else {
          if (i < n - i)
            return new ArrayList<>();
          i = n - i;
          n = i;
        }
      }
      i--;
    }
    return new ArrayList<>();
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Ternarian Weights";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      if (isPower(N)) {
        System.out.println("left pan: ");
        System.out.println("right pan: " + N);
      } else {
        for (int i = 1; i < 10000; i *= 3) {
          List<Integer> out = getPowerList(N + i);
          if (out.size() > 0) {
            Collections.sort(out, (a, b) -> b.compareTo(a));
            System.out.println("left pan: " + i);
            System.out.print("right pan:");
            out.stream().forEach((x) -> System.out.print(" " + x));
            System.out.println();
            break;
          }
        }
      }
      System.out.println();
    }
  }
}
