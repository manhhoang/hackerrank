package com.jd.hackerrank.graph;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class Pair {
  public Pair(int A, int B) {
    this.A = A;
    this.B = B;
  }

  public int A;
  public int B;
}

public class JourneytotheMoon {

  private static Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

  private static boolean[] visit;

  private static void addToGroup(int A, int B, int i) {
    Set<Integer> group = graph.get(i);
    if (group == null) {
      group = new HashSet<Integer>();
    }
    group.add(A);
    group.add(B);
    graph.put(i, group);
  }

  private static int bfs(int s) {
    visit[s] = true;
    int total = 0;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(s);
    while (!q.isEmpty()) {
      int v = q.poll();
      Set<Integer> vGroup = graph.get(v);
      if (vGroup != null) {
        int sizeVGroup = vGroup.size();
        for (int i = 0; i < graph.size(); i++) {
          if (!visit[i]) {
            Set<Integer> groups = graph.get(i);
            if (groups != null) {
              if (i != v) {
                total += sizeVGroup * groups.size();
              }
              q.add(i);
              visit[i] = true;
            }
          }
        }
      }
    }
    return total;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Journey to the Moon";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int N = sc.nextInt();
    int L = sc.nextInt();
    sc.nextLine();
    visit = new boolean[L];
    Pair[] pairs = new Pair[L];
    for (int i = 0; i < L; i++) {
      String[] lines = sc.nextLine().split(" ");
      int A = Integer.parseInt(lines[0]);
      int B = Integer.parseInt(lines[1]);
      Pair pair = new Pair(A, B);
      pairs[i] = pair;
    }

    addToGroup(pairs[0].A, pairs[0].B, 0);
    for (int k = 0; k < L; k++) {
      for (int h = 0; h < L; h++) {
        if (pairs[k].A == pairs[h].A || pairs[k].A == pairs[h].B || pairs[k].B == pairs[h].A
            || pairs[k].B == pairs[h].B) {
          addToGroup(pairs[h].A, pairs[h].B, k);
        }
      }
    }
    int count = bfs(0);
    System.out.println(count);
  }
}
