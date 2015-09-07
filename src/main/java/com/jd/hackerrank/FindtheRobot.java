package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class FindtheRobot {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Find the Robot";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    // O(n)
    for (double i = 0; i < t; i++) {
      long x = 0;
      long y = 0;
      long totalTurn = sc.nextLong();
      // for (int turn = 1; turn <= 4; turn++) {
      // if (turn == 1) {
      // x += turn + (totalTurn / 4);
      // } else if (turn == 3) {
      // x -= turn + (totalTurn / 4);
      // } else if (turn == 2) {
      // y += turn + (totalTurn / 4);
      // } else if (turn == 4) {
      // y -= turn + (totalTurn / 4);
      // }
      // }

      for (int r = 0; r < totalTurn; r++) {
        if (r % 4 == 0) {
          x += r + 1;
        } else if (r % 4 == 1) {
          y += r + 1;
        } else if (r % 4 == 2) {
          x -= r + 1;
        } else if (r % 4 == 3) {
          y -= r + 1;
        }
      }
      System.out.println(x + " " + y);
    }

  }
}
