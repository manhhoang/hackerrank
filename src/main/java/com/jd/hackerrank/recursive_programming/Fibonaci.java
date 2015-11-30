package com.jd.hackerrank.recursive_programming;

public class Fibonaci {

  private static int ans = 0;

  public static void main(String[] args) throws Exception {
    int n = 6;
    int count = fibo(1, 2, n, 2);
    System.out.println("count=" + count + " == ans=" + ans);
  }

  private static int fibo(int a, int b, int n, int count) {
    int fibo = a * b;
    count++;
    if (count < n) {
      int c = fibo(b, fibo, n, count);
      count = c;
    } else {
      ans = fibo;
    }
    return count;
  }
}
