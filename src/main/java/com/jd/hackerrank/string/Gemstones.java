package com.jd.hackerrank.string;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Gemstones {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Gemstones";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    sc.nextLine();
    String[] a = new String[N];
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextLine();
    }
    char[] chs = a[0].toCharArray();
    Arrays.sort(chs);
    int count = 0;
    for (int k = 0; k < chs.length; k++) {
      if (k == 0 || (k > 0 && chs[k] != chs[k - 1])) {
        boolean valid = true;
        for (int i = 1; i < N; i++) {
          if (!a[i].contains(String.valueOf(chs[k]))) {
            valid = false;
          }
        }
        if (valid)
          count++;
      }
    }
    System.out.println(count);
  }

}
