package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JavaArraylist {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java Arraylist";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    for (int i = 1; i <= t; i++) {
      int n = sc.nextInt();
      List<Integer> list = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        int val = sc.nextInt();
        list.add(val);
        map.put(i, list);
      }
    }

    int tSearch = sc.nextInt();
    for (int k = 1; k <= tSearch; k++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      List<Integer> values = map.get(x);
      if (values != null) {
        y = y - 1;
        if (y < values.size()) {
          System.out.println(values.get(y));
        } else {
          System.out.println("ERROR!");
        }
      } else {
        System.out.println("ERROR!");
      }
    }
  }
}
