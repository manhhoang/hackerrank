package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ASCIIArt {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/ASCII Art";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    int L = in.nextInt();
    in.nextLine();
    int H = in.nextInt();
    in.nextLine();
    String T = in.nextLine();
    for (int i = 0; i < H; i++) {
      String ROW = in.nextLine();
    }

    // Write an action using System.out.println()
    // To debug: System.err.println("Debug messages...");

    System.out.println("answer");

  }

}
