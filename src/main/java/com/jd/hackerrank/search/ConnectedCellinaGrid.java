package com.jd.hackerrank.search;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ConnectedCellinaGrid {

  public static int dfs(boolean[][] visited, boolean[][] matrix, int maxRows, int maxCols, int row,
      int col) {
    if (visited[row][col] || !matrix[row][col])
      return 0;

    int count = 1;

    // mark us as visited
    visited[row][col] = true;

    // check up
    if (row - 1 >= 0) {
      count += dfs(visited, matrix, maxRows, maxCols, row - 1, col);
      if (col - 1 >= 0)
        count += dfs(visited, matrix, maxRows, maxCols, row - 1, col - 1);
      if (col + 1 < maxCols)
        count += dfs(visited, matrix, maxRows, maxCols, row - 1, col + 1);
    }

    // check down
    if (row + 1 < maxRows) {
      count += dfs(visited, matrix, maxRows, maxCols, row + 1, col);
      if (col - 1 >= 0)
        count += dfs(visited, matrix, maxRows, maxCols, row + 1, col - 1);
      if (col + 1 < maxCols)
        count += dfs(visited, matrix, maxRows, maxCols, row + 1, col + 1);
    }

    // check left and right
    if (col - 1 >= 0)
      count += dfs(visited, matrix, maxRows, maxCols, row, col - 1);
    if (col + 1 < maxCols)
      count += dfs(visited, matrix, maxRows, maxCols, row, col + 1);

    return count;
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Connected Cell in a Grid";
    File file = new File(fileName);
    Scanner s = new Scanner(file);
    int numRows = Integer.parseInt(s.nextLine());
    int numCols = Integer.parseInt(s.nextLine());
    boolean[][] matrix = new boolean[numRows][numCols];
    boolean[][] visited = new boolean[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        visited[i][j] = false;
        matrix[i][j] = s.nextInt() == 1;
      }
    }
    int maxCount = 0;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < numCols; j++) {
        if (visited[i][j] == false) {
          int count = dfs(visited, matrix, numRows, numCols, i, j);
          if (count >= maxCount)
            maxCount = count;
        }
      }
    }
    System.out.println(maxCount);
  }
}
