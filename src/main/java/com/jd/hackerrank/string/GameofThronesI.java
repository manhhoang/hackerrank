package com.jd.hackerrank.string;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class GameofThronesI {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Game of Thrones - I";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    String s = sc.nextLine();
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.merge(s.substring(i, i + 1), 1, Integer::sum);
    }
    int c = 0;
    for (Entry<String, Integer> entry : map.entrySet()) {
      int val = entry.getValue();
      if (val % 2 != 0) {
        c++;
      }
    }
    if (c > 1)
      System.out.println("NO");
    else
      System.out.println("YES");
  }

}
