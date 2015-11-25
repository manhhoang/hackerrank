package com.jd.hackerrank;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HotelCity implements Comparable<HotelCity> {
  public HotelCity() {
  }

  public HotelCity(int budget, double score) {
    this.budget = budget;
    this.score = score;
  }

  public int budget;
  public double score;

  public int compareTo(HotelCity o) {
    if (this.score < o.score) {
      return 1;
    }
    return 0;
  }
}

public class BudgetFriendly {

  private static double maxScore = Double.MIN_VALUE;

  private static void process(List<HotelCity> output, int B) {
    int budget = 0;
    double score = 0;
    int count = 0;
    for (HotelCity c : output) {
      budget += c.budget;
      if (budget <= B) {
        score += c.score;
        count++;
      }
    }
    if (count == output.size()) {
      maxScore = Math.max(maxScore, score);
    }
  }

  private static void enumarate(int d, int B, List<ArrayList<HotelCity>> hotelList,
      List<HotelCity> output) {
    if (d == hotelList.size()) {
      process(output, B);
      return;
    }
    for (int i = 0; i < hotelList.get(d).size(); i++) {
      output.add(hotelList.get(d).get(i));
      enumarate(d + 1, B, hotelList, output);
      output.remove(output.size() - 1);
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Budget Friendly";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int C = sc.nextInt();
    int B = sc.nextInt();

    List<ArrayList<HotelCity>> hotelList = new ArrayList<ArrayList<HotelCity>>();
    for (int c = 0; c < C; c++) {
      int N = sc.nextInt();
      ArrayList<HotelCity> hotels = new ArrayList<HotelCity>();
      for (int i = 0; i < N; i++) {
        HotelCity hotel = new HotelCity(sc.nextInt(), sc.nextDouble());
        hotels.add(hotel);
      }
      hotelList.add(hotels);
    }

    List<HotelCity> output = new ArrayList<>();
    enumarate(0, B, hotelList, output);
    DecimalFormat df = new DecimalFormat("#.##");
    if (maxScore != Double.MIN_VALUE) {
      System.out.println(df.format(maxScore));
    } else {
      System.out.println("-1");
    }

  }
}