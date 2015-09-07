package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Java2DArray {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java 2D Array";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);

    // int[][] arr = new int[6][6];
    // for (int y = 0; y < 6; y++) {
    // for (int x = 0; x < 6; x++) {
    // arr[y][x] = sc.nextInt();
    // }
    // }
    // searchMaxHourGlass(arr);

    int[][] h = new int[6][6];
    for (int i = 0; i < 6; ++i)
      for (int j = 0; j < 6; ++j)
        h[i][j] = sc.nextInt();

    int m = -10000;
    for (int i = 0; i <= 3; ++i) {
      for (int j = 0; j <= 3; ++j) {
        int s =
            h[i][j] + h[i][j + 1] + h[i][j + 2] + h[i + 1][j + 1] + h[i + 2][j] + h[i + 2][j + 1]
                + h[i + 2][j + 2];
        if (s > m)
          m = s;
      }
    }
    System.out.println(m);
  }

  private static void searchMaxHourGlass(int[][] arr) {
    List<Integer> retList = new ArrayList<Integer>();
    for (int y = 0; y < 4; y++) {
      for (int x = 0; x < 4; x++) {
        int total = sumHourGlass(x, y, arr);
        retList.add(total);
      }
    }

    int max = 0;
    for (int i = 0; i < retList.size(); i++) {
      if (i == 0) {
        max = retList.get(i);
      }
      if (max < retList.get(i)) {
        max = retList.get(i);
      }
    }

    System.out.println(max);
  }

  private static int sumHourGlass(int x, int y, int[][] arr) {
    int sum = 0;
    for (int j = y; j <= y + 2; j++) {
      for (int i = x; i <= x + 2; i++) {
        if ((j == y + 1 && i == x) || (j == y + 1 && i == x + 2)) {
          continue;
        } else {
          if (arr[j][i] != 0) {
            sum += arr[j][i];
          }
        }
      }
    }

    return sum;
  }
}
