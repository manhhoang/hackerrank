package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Bar_FaceBook {

  private static Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();

  private static void dfs(int v, int K, List<Integer> a, List<List<Integer>> ret) {
    if (map.get(v) == null) {
      ret.add(new ArrayList<Integer>(a));
      Iterator<Integer> i = a.iterator();
      int c = 0;
      while (i.hasNext()) {
        Integer o = i.next();
        if (c > 1)
          i.remove();
        c++;
      }
    } else {
      for (int w : map.get(v)) {
        a.add(w);
        dfs(w, K, a, ret);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Bar_FaceBook";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int T = sc.nextInt();
    for (int t = 0; t < T; t++) {
      int N = sc.nextInt(); // number of person
      int K = sc.nextInt(); // Kth larget number
      Map<Integer, Integer[]> treeMap = new TreeMap<Integer, Integer[]>();
      for (int i = 0; i < N; i++) {
        int A = sc.nextInt(); // number of list for each person
        Integer[] a = new Integer[A]; // list number of each
        for (int j = 0; j < A; j++) {
          a[j] = sc.nextInt(); // element of list
        }
        treeMap.put(i, a);
      }
      for (int i = 0; i < N - 1; i++) {
        Integer[] values = treeMap.get(i);
        for (int j = 0; j < values.length; j++) {
          map.put(values[j], treeMap.get(i + 1));
        }
      }
      Integer[] firstList = treeMap.get(0);
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      for (int v : firstList) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(v);
        dfs(v, K, a, ret);
      }
      Set<Integer> ans = new HashSet<Integer>();
      for (List<Integer> list : ret) {
        Collections.sort(list);
        ans.add(list.get(K - 1));
      }
      System.out.println(ans.size());
    }
  }
}
