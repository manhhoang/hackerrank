package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChuckNorris {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/Chuck Norris";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    String MESSAGE = in.nextLine();
    String binary = stringToBinary(MESSAGE);
    char[] chars = binary.toCharArray();
    int count = 0;
    for (int i = 0; i < chars.length; i++) {
      if (i == chars.length - 1) {
        if (chars[i] != chars[i - 1]) {
          System.out.print(print(chars[i - 1], count));
          System.out.print(" " + print(chars[i], 1));
        } else {
          System.out.print(print(chars[i - 1], ++count));
        }
        break;
      }
      if (i > 0 && chars[i] != chars[i - 1]) {
        System.out.print(print(chars[i - 1], count) + " ");
        count = 1;
      } else {
        count++;
      }
    }
  }

  private static String print(char ch, int count) {
    String result = "0 ";
    if (ch == '0') {
      result = "00 ";
    }
    for (int i = 0; i < count; i++) {
      result += "0";
    }
    return result;
  }

  public static String stringToBinary(String str) {
    StringBuilder binary = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      String binChar = new String();
      byte[] bytes = str.substring(i, i + 1).getBytes();
      for (byte b : bytes) {
        binChar += Integer.toBinaryString((int) b);
      }
      binary.append(zeroPad(binChar));
    }

    return binary.toString();
  }

  private static String zeroPad(String binChar) {
    int len = binChar.length();
    if (len == 7)
      return binChar;
    String zeroPad = "0";
    for (int i = 1; i < 7 - len; i++)
      zeroPad = zeroPad + "0";
    return zeroPad + binChar;
  }

}
