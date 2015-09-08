package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

public class GameofThrones {
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Game of Thrones";
    File file = new File(fileName);

    Scanner myScan = new Scanner(file);
    String theStr = myScan.nextLine();
    int[] freq = new int[26];
    for (int i = 0; i < theStr.length(); i++) {
      freq[theStr.charAt(i) - 'a']++;
    }
    boolean singleFound = false;
    String ans = "YES";
    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (freq[i] % 2 == 1) {
        count++;
        if (count == 2) {
          singleFound = false;
        }
        if (singleFound) {
          ans = "NO";
          break;
        } else
          singleFound = true;
      }
    }
    System.out.println(ans);
    myScan.close();
  }
}
