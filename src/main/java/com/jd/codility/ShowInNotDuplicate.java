package com.jd.codility;

import java.util.HashMap;
import java.util.Map;

public class ShowInNotDuplicate {

  public static void solution(int[] a) {
    int N = a.length;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < N; i++) {
      Integer found = map.get(a[i]);
      if (found == null) {
        System.out.println(a[i]);
        found = 0;
      }
      map.put(a[i], ++found);
    }
  }

  public static void main(String[] args) throws Exception {
    int[] A = new int[5];
    A[0] = 1;
    A[1] = 3;
    A[2] = 2;
    A[3] = 1;
    A[4] = 2;
    solution(A);
  }
}
