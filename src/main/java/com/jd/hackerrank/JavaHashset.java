package com.jd.hackerrank;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JavaHashset {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java Hashset";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    sc.nextLine();
    Set<String> set = new HashSet<String>();
    for (int i = 0; i < t; i++) {
      String line = sc.nextLine();
      set.add(line);
      System.out.println(set.size());
    }
  }
}
