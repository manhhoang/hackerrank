package com.jd.hackerrank.cs;

public class CombinationsMultipleArray {

  private static void printSolve(int d, String s, String[][] a) {
    if (d == a.length) {
      System.out.println(s.substring(0, s.length() - 1));
      return;
    }
    for (int i = 0; i < a[d].length; i++) {
      printSolve(d + 1, s + a[d][i] + " ", a);
    }
    return;
  }

  private static int countSolve(int d, String s, String[][] a) {
    int count = 0;
    if (d == a.length) {
      return 1;
    }
    for (int i = 0; i < a[d].length; i++) {
      int c = countSolve(d + 1, s + a[d][i] + " ", a);
      count += c;
    }
    return count;
  }

  public static void main(String[] args) {
    String[][] a =
        {
            {"A1", "A2"}, {"B1", "B2", "B3"}, {"C1", "C2", "C3", "C4"}, {"D1", "D2", "D3", "D4"},
            {"E1", "E2"}};

    printSolve(0, "", a);
    System.out.println("Total combination: " + countSolve(0, "", a));
  }
}
