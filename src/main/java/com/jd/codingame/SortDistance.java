package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SortDistance {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/SortDistance";
    File file = new File(fileName);
    Scanner in = new Scanner(file);

    int N = in.nextInt();
    Map<Float, String> map = new TreeMap<Float, String>(Collections.reverseOrder());
    for (int i = 0; i < N; i++) {
      String item = in.next();
      float distance = in.nextFloat();
      map.put(distance, item);
    }
    Set set = map.entrySet();
    Iterator i = set.iterator();
    while (i.hasNext()) {
      Map.Entry me = (Map.Entry) i.next();
      System.out.print(me.getValue() + " ");
    }
  }
}
