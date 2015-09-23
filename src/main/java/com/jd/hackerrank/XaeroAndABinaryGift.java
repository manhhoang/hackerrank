package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class XaeroAndABinaryGift {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Xaero And A Binary Gift";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    String A = sc.nextLine();
    String B = sc.nextLine();
    char[] charA = A.toCharArray();
    char[] charB = B.toCharArray();
    int countA = 0;
    for (char ch : charA) {
      if (ch == '1') {
        countA++;
      }
    }
    int countB = 0;
    for (char chB : charB) {
      if (chB == '1') {
        countB++;
      }
    }
    int ans = countA;
    for (int i = 0; i < charA.length; i++) {
      if (charA[i] == charB[i] && charA[i] == '1') {
        ans--;
      }
    }
    if (countA == countB) {
      System.out.print(ans);
    } else {
      System.out.print("-1");
    }
  }
}
