package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Edge {
  public int v;
  public int w;
  public int r;
}

public class DijkstraShortestReach2 {

  private static final int INFINITY = Integer.MAX_VALUE;
  private static Map<Integer, ArrayList<Edge>> graph;
  private static int[] distTo;
  private static boolean[] visit;

  private static void addEdge(int v, int w, int r) {
    ArrayList<Edge> adj = graph.get(v);
    if (adj == null) {
      adj = new ArrayList<Edge>();
    }
    Edge edge = new Edge();
    edge.v = v;
    edge.w = w;
    edge.r = r;
    adj.add(edge);
    graph.put(v, adj);
  }

  private static void bfs(int s) {
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    distTo[s] = 0;
    visit[s] = true;
    while (!q.isEmpty()) {
      int v = q.poll();
      for (Edge adj : graph.get(v)) {
        if (distTo[adj.w] > distTo[v] + adj.r) {
          distTo[adj.w] = distTo[v] + adj.r;
        }
        if (!visit[adj.w]) {
          visit[adj.w] = true;
          q.add(adj.w);
        }
      }
    }
  }

  private static boolean hasPathTo(int v) {
    return visit[v];
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Dijkstra Shortest Reach 2";
    File file = new File(fileName);

    // Scanner sc = new Scanner(System.in);
    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      graph = new HashMap<Integer, ArrayList<Edge>>();
      int n = sc.nextInt();
      int m = sc.nextInt();
      distTo = new int[n + 1];
      visit = new boolean[n + 1];
      for (int v = 1; v < distTo.length; v++) {
        distTo[v] = INFINITY;
      }
      sc.nextLine();
      for (int j = 0; j < m; j++) {
        String[] lines = sc.nextLine().split(" ");
        int x = Integer.parseInt(lines[0]);
        int y = Integer.parseInt(lines[1]);
        int r = 0;
        if (lines.length == 3) {
          r = Integer.parseInt(lines[2]);
        }
        addEdge(x, y, r);
        addEdge(y, x, r);
      }
      int s = sc.nextInt();
      bfs(s);
      for (int vertex = 1; vertex < distTo.length; vertex++) {
        if (distTo[vertex] == 0) {
          continue;
        }
        if (hasPathTo(vertex)) {
          System.out.print(distTo[vertex]);
        } else {
          System.out.print("-1");
        }
        System.out.print(" ");
      }
      System.out.println("");
    }

  }
}
