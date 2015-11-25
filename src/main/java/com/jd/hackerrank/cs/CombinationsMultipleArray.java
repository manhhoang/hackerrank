package com.jd.hackerrank.cs;

import java.util.ArrayList;
import java.util.List;

public class CombinationsMultipleArray {

  private static void process(List<String> output) {
    System.out.println(output.toString());
    // output.stream().forEach(x -> System.out.print(x));
  }

  private static void enumarate(int d, String[][] a, List<String> output) {
    if (d == a.length) {
      process(output);
      return;
    }
    for (int i = 0; i < a[d].length; i++) {
      output.add(a[d][i]);
      enumarate(d + 1, a, output);
      output.remove(output.size() - 1);
    }
    return;
  }

  private static void enumarate(int d, String s, String[][] a) {
    if (d == a.length) {
      System.out.println(s.substring(0, s.length() - 1));
      return;
    }
    for (int i = 0; i < a[d].length; i++) {
      enumarate(d + 1, s + a[d][i] + " ", a);
    }
    return;
  }

  private static int countEnumarate(int d, String s, String[][] a) {
    int count = 0;
    if (d == a.length) {
      return 1;
    }
    for (int i = 0; i < a[d].length; i++) {
      int c = countEnumarate(d + 1, s + a[d][i] + " ", a);
      count += c;
    }
    return count;
  }

  public static void main(String[] args) {
    String[][] a = { {"0", "1", "2"}, {"0", "1", "2"}, {"0", "1", "2"}};
    List<String> output = new ArrayList<>();
    enumarate(0, a, output);
    System.out.println();

    String[][] b =
        {
            {"A1", "A2"}, {"B1", "B2", "B3"}, {"C1", "C2", "C3", "C4"}, {"D1", "D2", "D3", "D4"},
            {"E1", "E2"}};
    enumarate(0, "", b);
    System.out.println("Total combination: " + countEnumarate(0, "", b));
  }
}
