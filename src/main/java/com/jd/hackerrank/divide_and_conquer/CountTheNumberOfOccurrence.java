package com.jd.hackerrank.divide_and_conquer;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class CountTheNumberOfOccurrence {

    public static int solve(int[] a, int x) {
        int len = a.length;
        Arrays.sort(a);
        int m = Arrays.binarySearch(a, x);
        if (m < 0)
            return -1;

        int l = m - 1;
        int r = m + 1;
        int c = 1;
        while (true) {
            if (l >= 0 && a[l] == a[m]) {
                c++;
                l--;
            } else if (r < len && a[r] == a[m]) {
                c++;
                r++;
            } else {
                break;
            }
        }
        return c > 0 ? c : -1;
    }

    @Test
    public void test1() {
        Assert.assertEquals(4, solve(new int[]{1, 2, 2, 3, 3, 3, 3}, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, solve(new int[]{1, 1, 2, 2, 2, 2, 3}, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, solve(new int[]{1, 1, 2, 2, 2, 2, 3}, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals(2, solve(new int[]{1, 1, 2, 2, 2, 2, 3}, 1));
    }

    @Test
    public void test5() {
        Assert.assertEquals(-1, solve(new int[]{1, 1, 2, 2, 2, 2, 3}, 4));
    }

}
