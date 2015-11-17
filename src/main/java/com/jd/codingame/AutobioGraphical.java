package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AutobioGraphical {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/Autobio Graphical";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      String X = in.next();
      Map<String, Integer> map = new HashMap<String, Integer>();
      for (int i = 0; i < X.length(); i++) {
        Integer count = map.get(X.substring(i, i + 1));
        if (count == null) {
          count = 0;
        }
        map.put(X.substring(i, i + 1), ++count);
      }
      boolean isAns = true;
      for (int i = 0; i < X.length(); i++) {
        Integer count = map.get(String.valueOf(i));
        if (i != count) {
          System.out.println("0");
          isAns = false;
          break;
        }
      }
      if (isAns)
        System.out.println("1");
    }
  }

}
