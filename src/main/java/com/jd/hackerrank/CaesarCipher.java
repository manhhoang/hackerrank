package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CaesarCipher {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Caesar Cipher";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    int n = in.nextInt();
    in.nextLine();
    String S = in.nextLine();
    int K = in.nextInt();
    char[] chars = S.toCharArray();
    for (int i = 0; i < n; i++) {
      if (Character.isLetter(chars[i])) {
        int a = 0;
        if ((int) chars[i] >= 97) {
          a = ((int) chars[i] - 97 + K) % 26 + 97;
        } else {
          a = ((int) chars[i] - 65 + K) % 26 + 65;
        }
        System.out.print((char) a);
      } else {
        System.out.print(chars[i]);
      }
    }
  }

}
