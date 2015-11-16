package com.jd.codility;

import java.util.HashMap;
import java.util.Map;

public class FindSingularCharacter {

  public static String solution(String[] A) {
    String ans = "";
    int N = A.length;
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < N; i++) {
      Integer found = map.get(A[i]);
      if (found == null) {
        found = 0;
      }
      map.put(A[i], ++found);
    }
    for (Map.Entry entry : map.entrySet()) {
      if ((int) entry.getValue() == 1) {
        ans = (String) entry.getKey();
      }
    }
    return ans;
  }

  public static void main(String[] args) throws Exception {
    String[] A = new String[5];
    A[0] = "A";
    A[1] = "B";
    A[2] = "A";
    A[3] = "C";
    A[4] = "C";

    String ans = solution(A);
    System.out.println(ans);
  }
}
