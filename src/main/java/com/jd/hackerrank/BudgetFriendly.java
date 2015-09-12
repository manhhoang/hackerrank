package com.jd.hackerrank;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class HotelCity implements Comparable<HotelCity> {
  public HotelCity() {
  }

  public HotelCity(int budget, double score, int number) {
    this.budget = budget;
    this.score = score;
  }

  public int budget;
  public double score;
  public List<HotelCity> nextHotel;

  public void addNextHotel(HotelCity hotel) {
    if (nextHotel == null) {
      nextHotel = new ArrayList<HotelCity>();
    }
    nextHotel.add(hotel);
  }

  public int compareTo(HotelCity o) {
    if (this.score < o.score) {
      return 1;
    }
    return 0;
  }
}

public class BudgetFriendly {

  static Map<Integer, HotelCity> mapHotels = new HashMap<Integer, HotelCity>();

  private static HotelCity dfs(HotelCity hotel, int budget) {
    HotelCity curHotel = null;
    List<HotelCity> children = new ArrayList<HotelCity>();
    if (hotel.nextHotel != null) {
      for (HotelCity nextHotel : hotel.nextHotel) {
        if (hotel.budget + nextHotel.budget <= 50) {
          HotelCity h = dfs(nextHotel, budget);
          if (h != null) {
            children.add(h);
          }
        }
      }
    }
    if (children.size() > 0) {
      Collections.sort(children);
      for (HotelCity child : children) {
        if (hotel.budget + child.budget <= budget) {
          curHotel = new HotelCity();
          curHotel.budget = hotel.budget + child.budget;
          curHotel.score = hotel.score + child.score;
          break;
        }
      }
    }

    if (hotel.nextHotel == null) {
      curHotel = hotel;
    }
    return curHotel;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Budget Friendly";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int C = sc.nextInt();
    int B = sc.nextInt();

    Queue<List<HotelCity>> q = new LinkedList<List<HotelCity>>();
    int totalFirstCity = 0;
    int number = 0;
    for (int c = 0; c < C; c++) {
      int N = sc.nextInt();
      List<HotelCity> hotels = new ArrayList<HotelCity>();
      List<HotelCity> parentHotels = null;
      if (!q.isEmpty()) {
        parentHotels = q.poll();
      }
      for (int i = 0; i < N; i++) {
        HotelCity hotel = new HotelCity(sc.nextInt(), sc.nextDouble(), number++);
        if (parentHotels != null) {
          for (HotelCity parent : parentHotels) {
            parent.addNextHotel(hotel);
          }
        }
        hotels.add(hotel);
        if (c == 0) {
          totalFirstCity++;
          mapHotels.put(c * N + i, hotel);
        }
      }
      q.add(hotels);
    }
    DecimalFormat df = new DecimalFormat("#.##");
    List<HotelCity> hotels = new ArrayList<HotelCity>();
    for (int i = 0; i < totalFirstCity; i++) {
      HotelCity hotel = dfs(mapHotels.get(i), B);
      if (hotel != null) {
        hotels.add(hotel);
      }
    }

    double bestScore = 0;
    for (HotelCity h : hotels) {
      if (bestScore < h.score) {
        bestScore = h.score;
      }
    }
    if (bestScore != 0) {
      System.out.println(df.format(bestScore));
    } else {
      System.out.println("-1");
    }

  }
}