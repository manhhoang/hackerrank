package com.jd.codility.stacks_and_queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import junit.framework.Assert;

import org.junit.Test;

public class Brackets {

  public int solution(String S) {
    Map<String, String> map = new HashMap<>();
    map.put("{", "}");
    map.put("(", ")");
    map.put("[", "]");
    Stack<String> st = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      String k = S.substring(i, i + 1);
      if (map.containsKey(k)) {
        st.push(map.get(k));
      } else if (st.size() > 0) {
        String p = st.pop();
        if (!k.equals(p)) {
          return 0;
        }
      } else {
        return 0;
      }
    }
    if (st.size() > 0) {
      return 0;
    }
    return 1;
  }

  @Test
  public void test1() {
    Assert.assertEquals(1, solution("{([])}"));
  }

  @Test
  public void test2() {
    Assert.assertEquals(0, solution("([]"));
  }
}
