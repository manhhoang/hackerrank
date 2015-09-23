package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class GridChallenge {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Grid Challenge";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
  }
}
