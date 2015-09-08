package com.jd.hackerrank;

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
    Map<Character, Integer> an = new HashMap<Character, Integer>();
    for (int i = 0; i < src.length(); i++) {
      total++;
      char c = src.charAt(i);
      if (an.containsKey(c))
        an.put(c, an.get(c) + 1);
      else
        an.put(c, 1);
    }

    for (int j = 0; j < tar.length(); j++) {
      total++;
      char c = tar.charAt(j);
      if (an.containsKey(c) && an.get(c) != 0) {
        an.put(c, an.get(c) - 1);
        length += 2;
      }

    }

    System.out.println(total - length);

  }
}
