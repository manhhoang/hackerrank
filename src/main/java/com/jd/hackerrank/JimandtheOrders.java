package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class JimandtheOrders {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Jim and the Orders";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    int n = sc.nextInt();
    Map<Integer, List<Integer>> map = new TreeMap<>();
    for (int i = 1; i <= n; i++) {
      int t = sc.nextInt();
      int p = sc.nextInt();
      List<Integer> fans = map.getOrDefault(t + p, new ArrayList<>());
      fans.add(i);
      map.put(t + p, fans);
    }

    for (Map.Entry entry : map.entrySet()) {
      List<Integer> values = (ArrayList<Integer>) entry.getValue();
      values.stream().sorted().forEach((x) -> System.out.print(x + " "));
    }
  }

}
