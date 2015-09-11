package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Node implements Comparable<Node> {
  public int longestPath;
  public int steepest;

  public int compareTo(Node o) {
    if (this.longestPath != o.longestPath)
      return Integer.compare(this.longestPath, o.longestPath); // sorting in ascending order.
    if (this.steepest != o.steepest)
      return Integer.compare(this.steepest, o.steepest);
    return 0;
  }
}

public class SkiinginSingapore {

  private static int[][] arr;
  private static boolean[][] visit;
  private static Map<Integer, Node> map = new HashMap<Integer, Node>();

  private static Node dfs(int i, int j, int n, int m) {
    Node node = null;
    visit[i][j] = true;
    List<Node> nodes = new ArrayList<Node>();
    if (j > 0 && arr[i][j - 1] < arr[i][j]) { // left check
      Node no = new Node();
      int steep = arr[i][j] - arr[i][j - 1];
      if (!visit[i][j - 1]) {
        Node val = dfs(i, j - 1, n, m);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      } else {
        Node val = map.get(i * m + j - 1);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      }
    }

    if (j < n - 1 && arr[i][j + 1] < arr[i][j]) { // right check
      Node no = new Node();
      int steep = arr[i][j] - arr[i][j + 1];
      if (!visit[i][j + 1]) {
        Node val = dfs(i, j + 1, n, m);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      } else {
        Node val = map.get(i * m + j + 1);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      }
    }

    if (i > 0 && arr[i - 1][j] < arr[i][j]) { // up check
      Node no = new Node();
      int steep = arr[i][j] - arr[i - 1][j];
      if (!visit[i - 1][j]) {
        Node val = dfs(i - 1, j, n, m);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      } else {
        Node val = map.get((i - 1) * m + j);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      }
    }

    if (i < m - 1 && arr[i + 1][j] < arr[i][j]) { // down check
      Node no = new Node();
      int steep = arr[i][j] - arr[i + 1][j];
      if (!visit[i + 1][j]) {
        Node val = dfs(i + 1, j, n, m);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      } else {
        Node val = map.get((i + 1) * m + j);
        if (val != null) {
          no.longestPath = val.longestPath;
          no.steepest = val.steepest + steep;
          nodes.add(no);
        }
      }
    }

    Node longestNode = new Node();
    if (nodes.size() > 0) {
      Collections.sort(nodes);
      longestNode = nodes.get(nodes.size() - 1);
    }
    node = new Node();
    node.longestPath += longestNode.longestPath + 1;
    node.steepest += longestNode.steepest;
    map.put(i * m + j, node);

    return node;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Skiing in Singapore";
    File file = new File(fileName);

    long t1 = System.currentTimeMillis();
    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    arr = new int[m][n];
    visit = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    List<Node> nodes = new ArrayList<Node>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!visit[i][j]) {
          Node node = dfs(i, j, n, m);
          if (node != null) {
            nodes.add(node);
          }
        }
      }
    }
    int longest = 0;
    int steepest = 0;
    for (Node node : nodes) {
      if (node.longestPath > longest) {
        longest = node.longestPath;
        steepest = node.steepest;
      } else if (node.longestPath == longest && node.steepest > steepest) {
        steepest = node.steepest;
      }
    }
    long t2 = System.currentTimeMillis();
    System.out.println(longest + " " + steepest);
    System.out.println(t2 - t1 + " ms");

  }

}
