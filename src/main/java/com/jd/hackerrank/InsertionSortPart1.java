package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class InsertionSortPart1 {

  public static void insertIntoSorted(int[] ar) {
    int v = ar[ar.length - 1];
    for (int i = ar.length - 1; i >= 0; i--) {
      if (i > 0) {
        if (ar[i] > v && v > ar[i - 1]) {
          ar[i] = v;
          printArray(ar);
          break;
        } else {
          ar[i] = ar[i - 1];
          printArray(ar);
        }
      } else {
        if (ar[i] > v) {
          ar[i] = v;
          printArray(ar);
        }
      }
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Insertion Sort - Part 1";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int s = sc.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = sc.nextInt();
    }
    insertIntoSorted(ar);
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }
}
