package com.jd.hackerrank;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JavaMap {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Java Map";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    sc.nextLine();
    Map<String, String> map = new HashMap<String, String>();
    for (int i = 0; i < t; i++) {
      String name = sc.nextLine();
      String phone = sc.nextLine();
      map.put(name, phone);
    }
    while (sc.hasNext()) {
      String nameSearch = sc.nextLine();
      String retPhone = map.get(nameSearch);
      if (retPhone != null) {
        System.out.println(nameSearch + "=" + retPhone);
      } else {
        System.out.println("Not found");
      }
    }
  }
}
