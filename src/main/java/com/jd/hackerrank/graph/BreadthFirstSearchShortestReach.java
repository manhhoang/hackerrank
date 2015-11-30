package com.jd.hackerrank.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {

  private static Map<Integer, List<Integer>> graph;
  private static boolean[] visit;
  private static int[] distTo; // distTo[v] = distance of shortest s->v path

  private static void addEdge(Integer v, Integer w) {
    List<Integer> adj = graph.get(v);
    if (adj == null) {
      adj = new ArrayList<Integer>();
      graph.put(v, adj);
    }
    adj.add(w);
  }

  private static void bfs(int s) {
    Queue<Integer> q = new LinkedList<Integer>();
    distTo[s] = 0;
    visit[s] = true;
    q.add(s);

    while (!q.isEmpty()) {
      int v = q.poll();
      for (int w : graph.get(v)) {
        if (!visit[w]) {
          distTo[w] = distTo[v] + 6;
          visit[w] = true;
          q.add(w);
        }
      }
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Breadth First Search Shortest Reach 1";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      graph = new HashMap<Integer, List<Integer>>();
      visit = new boolean[n + 1];
      distTo = new int[n + 1];
      for (int v = 1; v < n + 1; v++) {
        distTo[v] = -1;
      }
      for (int j = 0; j < m; j++) {
        int v = sc.nextInt();
        int w = sc.nextInt();
        addEdge(v, w);
        addEdge(w, v);
      }
      int s = sc.nextInt();
      bfs(s);
      for (int vertex = 1; vertex < distTo.length; vertex++) {
        if (distTo[vertex] == 0) {
          continue;
        }
        System.out.print(distTo[vertex] + " ");
      }
      System.out.println("");
    }
  }
}
