package com.jd.hackerrank;

import junit.framework.Assert;

import org.junit.Test;

public class Robot {

  public String solution(String command) {
    int[] arr = new int[10];
    int index = 0;
    for (int i = 0; i < command.length(); i++) {
      if (command.charAt(i) == 'P') {
        index = 0;
      } else if (command.charAt(i) == 'M') {
        index++;
      } else {
        arr[index]++;
      }
    }
    String ans = "";
    for (int i = 0; i < arr.length; i++) {
      ans += String.valueOf(Integer.toString(arr[i], 15)).toUpperCase();
    }
    return ans;
  }

  @Test
  public void test1() {
    Assert.assertEquals("0211000000", solution("PMLPMMMLPMLPMML"));
  }

  @Test
  public void test2() {
    Assert.assertEquals("A000000000", solution("PLPLPLPLPLPLPLPLPLPL"));
  }

  @Test
  public void test3() {
    Assert.assertEquals("B000000000", solution("PLPLPLPLPLPLPLPLPLPLPL"));
  }
}
