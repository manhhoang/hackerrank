package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class BasketballAmazon {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Basketball Amazon";
    File file = new File(fileName);

    Scanner in = new Scanner(file);
    int balls_size = 0;
    balls_size = Integer.parseInt(in.nextLine());
    String[] balls = new String[balls_size];
    String balls_item;
    for (int balls_i = 0; balls_i < balls_size; balls_i++) {
      try {
        balls_item = in.nextLine();
      } catch (Exception e) {
        balls_item = null;
      }
      balls[balls_i] = balls_item;
    }

    int total = totalScore(balls);
    System.out.println(total);
  }
  
  static int totalScore(String[] balls) {
    int total = 0;
    int score = 0;
    int x = 0; // last score index
    for (int i = 0; i < balls.length; i++) {
      if ("X".equals(balls[i])) {
        score = Integer.parseInt(balls[x - 1]) * 2;
        balls[x] = String.valueOf(score);
      } else if ("+".equals(balls[i])) {
        score = Integer.parseInt(balls[x - 1]) + Integer.parseInt(balls[x - 2]);
        balls[x] = String.valueOf(score);
      } else if ("Z".equals(balls[i])) {
        score = -Integer.parseInt(balls[x - 1]);
        x -= 2;
      } else {
        score = Integer.parseInt(balls[i]);
        balls[x] = String.valueOf(score);
      }
      x++;
      total += score;
    }

    return total;
  }

  static int totalScoreByStack(String[] balls) {
    int total = 0;
    int score = 0;
    Stack<Integer> st = new Stack<Integer>();
    for (int i = 0; i < balls.length; i++) {
      if ("X".equals(balls[i])) {
        score = st.size() > 0 ? st.lastElement() * 2 : 0;
        st.add(score);
      } else if ("+".equals(balls[i])) {
        score = st.size() > 1 ? st.lastElement() + st.elementAt(st.size() - 2) : 0;
        st.add(score);
      } else if ("Z".equals(balls[i])) {
        score = -st.pop();
      } else {
        score = Integer.parseInt(balls[i]);
        st.add(score);
      }
      total += score;
    }
    return total;
  }

  static int totalScoreByArray(String[] balls) {
    int total = 0;
    int score = 0;
    int[] scoreds = new int[balls.length];
    int x = 0; // last score index
    for (int i = 0; i < balls.length; i++) {
      if ("X".equals(balls[i])) {
        score = scoreds[x - 1] * 2;
        scoreds[x] = score;
      } else if ("+".equals(balls[i])) {
        score = scoreds[x - 1] + scoreds[x - 2];
        scoreds[x] = score;
      } else if ("Z".equals(balls[i])) {
        score = -scoreds[x - 1];
        scoreds[x - 1] = 0;
        x -= 2;
      } else {
        score = Integer.parseInt(balls[i]);
        scoreds[x] = score;
      }
      x++;
      total += score;
    }

    return total;
  }
  
}
