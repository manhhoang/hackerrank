package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TriaglePoint {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/TriaglePoint";
    File file = new File(fileName);
    Scanner in = new Scanner(file);
    
    int[][] a = new int[3][3];
    for (int i = 0; i < 3; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      a[x][y] = 0;
    }
    int N = in.nextInt();
    for (int i = 0; i < N; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      
    }
    for (int i = 0; i < N; i++) {

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");

      System.out.println("IN/OUT");
    }
  }
}
