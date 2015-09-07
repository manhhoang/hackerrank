package com.jd.hackerrank;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class FacilitiesExtraction {

  public static boolean search(String facility, String des) {
    int M = facility.length();
    int N = des.length();
    for (int i = 0; i <= N - M; i++) {
      int j;
      for (j = 0; j < M; j++) {
        if (des.charAt(i + j) != facility.charAt(j)) {
          break;
        }
      }
      if (j == M) {
        return true;
      }
    }
    return false;
  }

  @SuppressWarnings({"resource", "rawtypes", "unchecked"})
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Facilities Extraction";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    sc.nextLine();
    TreeMap tm = new TreeMap();
    for (int i = 0; i < n; i++) {
      String fa = sc.nextLine();
      tm.put(fa, i);
    }
    Set set = tm.entrySet();
    String des = sc.nextLine();
    Iterator i = set.iterator();
    while (i.hasNext()) {
      Map.Entry me = (Map.Entry) i.next();
      String facility = (String) me.getKey();
      if (search(facility.toLowerCase(), des.toLowerCase())) {
        System.out.println(facility);
      }
    }
  }
}
