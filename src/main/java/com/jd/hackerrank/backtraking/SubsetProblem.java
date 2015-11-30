package com.jd.hackerrank.backtraking;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SubsetProblem {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Subset Problem";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < N; i++){
      a[i] = sc.nextInt();
    }

  }

}
