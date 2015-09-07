package com.jd.hackerrank;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class HotelCity {
  public HotelCity(int budget, double score, int number) {
    this.budget = budget;
    this.score = score;
    this.number = number;
  }

  public int budget;
  public double score;
  public int number;
  public List<HotelCity> nextHotel;

  public void addNextHotel(HotelCity hotel) {
    if (nextHotel == null) {
      nextHotel = new ArrayList<HotelCity>();
    }
    nextHotel.add(hotel);
  }
}

public class BudgetFriendly {

  static Map<Integer, HotelCity> mapHotels = new HashMap<Integer, HotelCity>();
  static int[] budgetTo;
  static double[] scoreTo;

  private static void bfs(HotelCity hotel, int budget) {
    double bestScore = 0;
    budgetTo[hotel.number] = hotel.budget;
    scoreTo[hotel.number] = hotel.score;
    Queue<Integer> q = new LinkedList<Integer>();
    q.add(hotel.number);
    while(!q.isEmpty()){
      int hotelNo = q.poll();
      List<HotelCity> hotels = mapHotels.get(hotelNo);
      if(hotels != null){
        for(HotelCity h:hotels){
          if(budgetTo(hotelNo) + h.budget <= budget){
            budgetTo[h.number] = budgetTo(hotelNo) + h.budget;
            if(scoreTo[hotelNo] + h.score > scoreTo[h.number]){
              scoreTo[h.number] = scoreTo[hotelNo] + h.score;
            }
          }
        }
      }
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
          mapHotels.put(i, hotel);
        }
      }
      q.add(hotels);
    }
    DecimalFormat df = new DecimalFormat("#.##");
    for (int i = 0; i < totalFirstCity; i++) {
      bfs(mapHotels.get(i), B);
    }

    if (bestScore != 0) {
      System.out.println(df.format(bestScore));
    } else {
      System.out.println("-1");
    }

  }
}