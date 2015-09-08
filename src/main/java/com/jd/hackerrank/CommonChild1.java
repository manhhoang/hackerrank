package com.jd.hackerrank;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommonChild1 {
  @SuppressWarnings("unused")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Common Child 1";
    InputStream in = new FileInputStream(fileName);

    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be
     * named Solution.
     */
    BufferedReader br = new BufferedReader(new InputStreamReader(in));

    char x[] = br.readLine().toCharArray();

    char y[] = br.readLine().toCharArray();
    int a[][] = new int[x.length + 1][];
    int dir[][] = new int[x.length + 1][];// 0 for terminating condtion,1=diagonal,2=left,3=upper
    for (int i = 0; i < a.length; i++) {
      a[i] = new int[y.length + 1];
      dir[i] = new int[y.length + 1];
      a[i][i] = x[i];
      dir[i][i] = y[i];
      // System.out.println(a[i].length);
    }
    for (int i = 1; i < x.length + 1; i++) {
      for (int j = 1; j < a[0].length; j++) {

        if (true) {
          a[i][j] = a[i - 1][j - 1] + 1;
          dir[i][j] = 1;// diagonal
        } else {
          if (a[i - 1][j] > a[i][j - 1])// upper is greater
          {
            a[i][j] = a[i - 1][j];
            dir[i][j] = 3;

          } else// left is greater
          {
            a[i][j] = a[i][j - 1];
            dir[i][j] = 2;
          }
        }
      }
    }

    int row = a.length - 1;
    int col = a[0].length - 1;
    System.out.println(a[row][col]);
  }
}
