package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EvenTree {
  private static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
  private static boolean[] visit;
  private static int adgeRemove = 0;

  private static void addEdge(Integer v, Integer w) {
    List<Integer> adj = graph.get(v);
    if (adj == null) {
      adj = new ArrayList<Integer>();
      graph.put(v, adj);
    }
    adj.add(w);
  }

  private static int dfs(int v) {
    visit[v] = true;
    int numVertex = 0;
    for (Integer adj : graph.get(v)) {
      if (!visit[adj]) {
        int numNode = dfs(adj);
        if (numNode % 2 == 0) {
          adgeRemove++;
        } else {
          numVertex += numNode;
        }
      }
    }
    return numVertex + 1;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Even Tree";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    int m = sc.nextInt();
    visit = new boolean[n + 1];

    for (int i = 0; i < m; i++) {
      int v = sc.nextInt();
      int w = sc.nextInt();
      addEdge(v, w);
      addEdge(w, v);
    }
    dfs(1);
    System.out.println(adgeRemove);
  }
}
