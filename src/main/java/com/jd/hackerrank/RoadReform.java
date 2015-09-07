package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class RoadReform {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Road Reform";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    for(int i = 0; i< m; i++){
      
    }

  }
}
