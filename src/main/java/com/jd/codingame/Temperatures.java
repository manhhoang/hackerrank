package com.jd.codingame;

import java.io.File;
import java.util.Scanner;

public class Temperatures {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/Temperatures";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    int n = in.nextInt(); // the number of temperatures to analyse
    if (n == 0) {
      System.out.println("0");
    } else {
      in.nextLine();
      String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to
                                    // 5526

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");

      int[] arr = new int[n];
      String[] numbers = temps.split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(numbers[i]);
      }

      int minPos = Integer.MAX_VALUE;
      int maxNeg = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        if (arr[i] >= 0) {
          minPos = Math.min(minPos, arr[i]);
        }
        if (arr[i] < 0) {
          maxNeg = Math.max(maxNeg, arr[i]);
        }
      }

      if (Math.abs(minPos) <= Math.abs(maxNeg) && maxNeg != Integer.MIN_VALUE
          || maxNeg == Integer.MIN_VALUE) {
        System.out.println(minPos);
      } else {
        System.out.println(maxNeg);
      }
    }
  }
}
