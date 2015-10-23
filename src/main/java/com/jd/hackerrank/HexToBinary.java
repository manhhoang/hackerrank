package com.jd.hackerrank;

import java.io.IOException;

public class HexToBinary {
  public static String hexToBinary(String hex) {
    String hexChar;
    String binChar;
    String binary = "";
    int len = hex.length() / 2;
    for (int i = 0; i < len; i++) {
      hexChar = hex.substring(2 * i, 2 * i + 2);
      // convert hex char to integer
      int convInt = Integer.parseInt(hexChar, 16);
      // convert integer to binary
      binChar = Integer.toBinaryString(convInt);
      binChar = zeroPad(binChar);
      if (i == 0)
        binary = binChar;
      else
        binary = binary + binChar;
    }
    return binary;
  }

  private static String zeroPad(String binChar) {
    int len = binChar.length();
    if (len == 8)
      return binChar;
    String zeroPad = "0";
    for (int i = 1; i < 8 - len; i++)
      zeroPad = zeroPad + "0";
    return zeroPad + binChar;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(hexToBinary("A14AA1DBDB818F9759"));

  }
}
