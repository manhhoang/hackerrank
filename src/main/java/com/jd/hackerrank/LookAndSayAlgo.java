package com.jd.hackerrank;

import junit.framework.Assert;

import org.junit.Test;

public class LookAndSayAlgo {

  private String lookAndSay(String start, int n) {
    String ans = start;
    while (n > 0) {
      ans = "";
      for (int i = 0; i < start.length();) {
        int j = i;
        int count = 0;
        while (j < start.length()) {
          if (start.charAt(i) == start.charAt(j)) {
            j++;
            count++;
          } else {
            break;
          }
        }
        if (i != j) {
          ans += Integer.toString(count) + start.charAt(i);
          i = j;
        } else {
          i++;
        }
      }
      start = ans;
      n--;
    }

    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals("1", lookAndSay("1", 0));
  }

  @Test
  public void test2() {
    Assert.assertEquals("21", lookAndSay("11", 1));
  }

  @Test
  public void test3() {
    Assert.assertEquals("1211", lookAndSay("11", 2));
  }

  @Test
  public void test4() {
    Assert.assertEquals("111221", lookAndSay("11", 3));
  }

  @Test
  public void test5() {
    Assert.assertEquals("312211", lookAndSay("11", 4));
  }

  @Test
  public void test6() {
    Assert.assertEquals("13112221", lookAndSay("11", 5));
  }
}
