package com.jd.hackerrank.greedy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SherlockandTheBeast {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Sherlock and The Beast";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt();
      String ans = "";
      for (int i = N; i >= 0; i--) {
        if (i % 3 == 0 && (N - i) % 5 == 0) {
          for (int k = 0; k < i; k++)
            ans += "5";
          for (int k = 0; k < N - i; k++)
            ans += "3";
          break;
        }
      }
      if (ans.equals(""))
        System.out.println("-1");
      else {
        System.out.println(ans);
      }
    }

  }

}
