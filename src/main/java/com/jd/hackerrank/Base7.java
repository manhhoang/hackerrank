package com.jd.hackerrank;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class Base7 {

    private String convert(long input) {
        Map<String, String> map = new HashMap<>();
        map.put("0", "0");
        map.put("1", "a");
        map.put("2", "t");
        map.put("3", "l");
        map.put("4", "s");
        map.put("5", "i");
        map.put("6", "n");
        String base7 = Long.toString(input, 7);
        String ans = "";
        for (int i = 0; i < base7.length(); i++) {
            ans += map.get(String.valueOf(base7.charAt(i)));
        }
        return ans;

    }

    @Test
    public void test1() {
        Assert.assertEquals("a0", convert(7));
    }

    @Test
    public void test2() {
        Assert.assertEquals("atlassian", convert(7792875));
    }

    @Test
    public void test3() {
        Assert.assertEquals("0", convert(0));
    }

    @Test
    public void test4() {
        Assert.assertEquals("a", convert(1));
    }
}
