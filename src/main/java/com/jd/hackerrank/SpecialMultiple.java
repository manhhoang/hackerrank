package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class SpecialMultiple {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Special Multiple";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
  }
}
