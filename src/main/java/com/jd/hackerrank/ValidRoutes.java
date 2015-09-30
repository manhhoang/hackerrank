package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidRoutes {

  private Map<String, Integer> g = new HashMap<String, Integer>();

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Valid Routes";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    
  }
}
