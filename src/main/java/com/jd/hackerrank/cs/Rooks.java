/*************************************************************************
 * Compilation: javac Rooks.java Execution: java Rooks N
 * 
 * Print out all solutions to the N-rooks problem, i.e., generate all N! permutations.
 *
 * % java Rooks 3 0 1 2 0 2 1 1 0 2 1 2 0 2 1 0 2 0 1
 *
 *
 *************************************************************************/
package com.jd.hackerrank.cs;

public class Rooks {
  private int N; // N-by-N checkerboard
  private int[] rooks; // permutation of rooks

  // constructor
  public Rooks(int N) {
    this.N = N;
    rooks = new int[N];
    for (int i = 0; i < N; i++)
      rooks[i] = i;
    enumerate(0);
  }

  // Print out current permutation
  private void process() {
    for (int i = 0; i < N; i++)
      System.out.print(rooks[i] + " ");
    System.out.println();
  }

  // enumerate all solutions
  public void enumerate(int n) {

    // found a solution
    if (n == N) {
      process();
      return;
    }

    // continue searching
    for (int i = n; i < N; i++) {
      exch(n, i);
      enumerate(n + 1);
      exch(i, n);
    }
  }

  // exchange rooks[i] and rooks[j]
  private void exch(int i, int j) {
    int temp = rooks[i];
    rooks[i] = rooks[j];
    rooks[j] = temp;
  }

  public static void main(String[] args) {
    int N = 3;
    Rooks rooks = new Rooks(N);
  }
}
