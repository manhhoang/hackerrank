package com.jd.hackerrank;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class BaseAtlassian {

  public static String solution(int n) {
    Map<String, String> map = new HashMap<>();
    map.put("0", "0");
    map.put("1", "a");
    map.put("2", "t");
    map.put("3", "l");
    map.put("4", "s");
    map.put("5", "i");
    map.put("6", "n");
    String base7 = Integer.toString(n, 7);
    String ans = "";
    for (int i = 0; i < base7.length(); i++) {
      ans += map.get(String.valueOf(base7.charAt(i)));
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals("a0", solution(7));
  }

  @Test
  public void test2() {
    Assert.assertEquals("atlassian", solution(7792875));
  }
}
