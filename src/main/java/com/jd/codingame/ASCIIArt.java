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
    char[] chars = T.toUpperCase().toCharArray();
    for (int i = 0; i < H; i++) {
      String ROW = in.nextLine();
      for (int j = 0; j < chars.length; j++) {
        int index = Character.codePointAt(chars, j);
        if (index >= 65 && index <= 90) {
          String letter = ROW.substring((index - 65) * L, (index - 65) * L + L);
          System.out.print(letter);
        } else {
          String letter = ROW.substring(ROW.length() - L, ROW.length());
          System.out.print(letter);
        }
      }
      System.out.println();
    }
  }

}
