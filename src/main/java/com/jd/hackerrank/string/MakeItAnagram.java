package com.jd.hackerrank.string;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MakeItAnagram {

  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Make It Anagram";
    File file = new File(fileName);

    Scanner in = new Scanner(file);
    String src = (in.nextLine());
    String tar = in.nextLine();
    int length = 0;
    int total = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < src.length(); i++) {
      total++;
      char c = src.charAt(i);
      map.merge(c, 1, Integer::sum);
    }

    for (int j = 0; j < tar.length(); j++) {
      total++;
      char c = tar.charAt(j);
      if (map.containsKey(c) && map.get(c) != 0) {
        map.put(c, map.get(c) - 1);
        length += 2;
      }

    }

    System.out.println(total - length);

  }
}
