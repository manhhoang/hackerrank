package com.jd.codingame;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TriaglePoint {

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/codingame/TriaglePoint";
    File file = new File(fileName);
    Scanner in = new Scanner(file);
    
    int[][] a = new int[3][3];
    for (int i = 0; i < 3; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      a[x][y] = 0;
    }
    int N = in.nextInt();
    for (int i = 0; i < N; i++) {
      int x = in.nextInt();
      int y = in.nextInt();
      
    }
    for (int i = 0; i < N; i++) {

      // Write an action using System.out.println()
      // To debug: System.err.println("Debug messages...");

      System.out.println("IN/OUT");
    }
  }
}


INPUT:
Line 1: A string S to encode.

OUTPUT:
Line 1: The run length encoded version of S.

CONSTRAINTS:
0 < S < 50

EXAMPLE:
Input
abbcccdddd
Output
1a2b3c4d


import java.util.*;
import java.io.*;
import java.math.*;
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String S = in.nextLine();
        char[] chars=S.toCharArray();
        int n = chars.length;
        Arrays.sort(chars);
        for(int i=0;i<n;){
            int j=i;
            while(j<n && chars[j] == chars[j+1]){
                j++;
            }
            System.out.print(j-i+chars[i]);
            i=j;
        }
    }
}