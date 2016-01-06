package com.jd.hackerrank.string;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SherlockandAnagrams {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Sherlock and Anagrams";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    sc.nextLine();
    for (int t = 0; t < T; t++) {
      String s = sc.nextLine();
      int count = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int j = i + 1; j < s.length(); j++) {
          char[] a = s.substring(i, j).toCharArray();
          Arrays.sort(a);
          for (int k = i + 1; k < s.length(); k++) {
            if (k + a.length <= s.length()) {
              char[] b = s.substring(k, k + a.length).toCharArray();
              Arrays.sort(b);
              if (Arrays.equals(a, b)) {
                count++;
              }
            }
          }
        }
      }
      System.out.println(count);
    }
  }

}
