package com.jd.hackerrank.graph;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConnectedCellinaGrid1 {
  public static int search(boolean[][] visited, boolean[][] matrix, int maxRows, int maxCols,
      int row, int col) {
    if (visited[row][col] || !matrix[row][col])
      return 0;
    int count = 1;
    // mark us as visited
    visited[row][col] = true;
    // check up
    if (row - 1 >= 0) {
      count += search(visited, matrix, maxRows, maxCols, row - 1, col);
      if (col - 1 >= 0)
        count += search(visited, matrix, maxRows, maxCols, row - 1, col - 1);
      if (col + 1 < maxCols)
        count += search(visited, matrix, maxRows, maxCols, row - 1, col + 1);
    }
    // check down
    if (row + 1 < maxRows) {
      count += search(visited, matrix, maxRows, maxCols, row + 1, col);
      if (col - 1 >= 0)
        count += search(visited, matrix, maxRows, maxCols, row + 1, col - 1);
      if (col + 1 < maxCols)
        count += search(visited, matrix, maxRows, maxCols, row + 1, col + 1);
    }
    // check left
    if (col - 1 >= 0)
      count += search(visited, matrix, maxRows, maxCols, row, col - 1);
    if (col + 1 < maxCols)
      count += search(visited, matrix, maxRows, maxCols, row, col + 1);
    return count;
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Connected Cell in a Grid 1";
    File file = new File(fileName);
    Scanner s = new Scanner(file);
    int numRows = Integer.parseInt(s.nextLine());
    int numCols = Integer.parseInt(s.nextLine());
    boolean[][] matrix = new boolean[numRows][numCols];
    boolean[][] counted = new boolean[numRows][numCols];
    for(int i=0; i<numRows; i++){
        for(int j=0; j<numCols; j++){
            counted[i][j] = false;
            matrix[i][j] = s.nextInt()==1;
        }
    }
    int maxCount =0;
    for(int i=0; i<numRows; i++){
        for(int j=0; j<numCols; j++){
            if(counted[i][j] == false){
                int dfs = search(counted, matrix, numRows, numCols, i, j);
                if(dfs>=maxCount) maxCount = dfs;
            }
        }
    }
    System.out.println(maxCount);
}
}
