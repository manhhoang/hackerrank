package com.jd.hackerrank;

import junit.framework.Assert;

import org.junit.Test;

public class LookAndSay {

  public String solution(String n, int k) {
    String ans = "";
    while (k > 0) {
      ans = "";
      for (int i = 0; i < n.length();) {
        int j = i;
        int count = 0;
        while (j < n.length()) {
          if (n.charAt(i) == n.charAt(j)) {
            j++;
            count++;
          } else {
            break;
          }
        }
        if (i != j) {
          ans += count + "" + n.charAt(i);
          i = j;
        } else {
          i++;
        }
      }
      n = ans;
      k--;
    }

    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals("21", solution("11", 1));
  }

  @Test
  public void test2() {
    Assert.assertEquals("1211", solution("11", 2));
  }

  @Test
  public void test3() {
    Assert.assertEquals("111221", solution("11", 3));
  }

  @Test
  public void test4() {
    Assert.assertEquals("312211", solution("11", 4));
  }

  @Test
  public void test5() {
    Assert.assertEquals("13112221", solution("11", 5));
  }
}
