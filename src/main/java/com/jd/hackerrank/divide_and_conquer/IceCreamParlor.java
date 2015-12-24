package com.jd.hackerrank.divide_and_conquer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IceCreamParlor {

  public static class Index {
    int val;
    int index;

    public static Comparator ValueComparator = new Comparator() {
      @Override
      public int compare(Object o1, Object o2) {
        return ((Index) o1).val - ((Index) o2).val;
      }
    };
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Ice Cream Parlor";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int M = sc.nextInt();
      int N = sc.nextInt();
      Index[] a = new Index[N];
      for (int i = 0; i < N; i++) {
        Index index = new IceCreamParlor.Index();
        index.val = sc.nextInt();
        index.index = i + 1;
        a[i] = index;
      }
      Arrays.sort(a, Index.ValueComparator);
      int lo = 0;
      int hi = N - 1;
      while (lo <= hi) {
        if (a[lo].val + a[hi].val < M) {
          lo++;
        } else if (a[lo].val + a[hi].val > M) {
          hi--;
        } else {
          if (a[lo].index < a[hi].index)
            System.out.println(a[lo].index + " " + a[hi].index);
          else
            System.out.println(a[hi].index + " " + a[lo].index);
          break;
        }
      }

    }
  }

}
