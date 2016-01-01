package com.jd.hackerrank.prefix_sum;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class MaximiseSum {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Maximise Sum";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int n = sc.nextInt();
      long m = sc.nextLong();
      long[] a = new long[n];
      TreeSet<Long> set = new TreeSet<>();
      long ans = 0;
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextLong() % m;
        if (i > 0) {
          a[i] = (a[i - 1] + a[i]) % m;
        }
        ans = Math.max(ans, a[i]);

        Long higher = set.higher(a[i]);
        if (higher != null) {
          ans = Math.max(ans, ((a[i] - higher) % m + m) % m);
        }

        set.add(a[i]);
      }
      System.out.println(ans);
    }
  }

}
