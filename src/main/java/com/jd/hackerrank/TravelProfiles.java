package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hotel {
  public Hotel(int id, int budget) {
    this.id = id;
    this.budget = budget;
  }

  public Hotel(int budget) {
    this.budget = budget;
  }

  public int id;
  public int budget;
  public ArrayList<String> facilities;

  public void addFacility(String facility) {
    if (facilities == null) {
      facilities = new ArrayList<String>();
    }
    facilities.add(facility);
  }

  public int getNumberOfFacilities() {
    int num = facilities != null ? facilities.size() : 0;
    return num;
  }
}

public class TravelProfiles {

  private static Hotel[] searchHotel(Hotel[] hotels, Hotel hotelRequire) {
    List<Hotel> temHotels = new ArrayList<Hotel>();
    for (Hotel hotel : hotels) {
      if (hotel.budget <= hotelRequire.budget && isMeetFacility(hotel.facilities, hotelRequire)) {
        temHotels.add(hotel);
      }
    }
    Hotel[] retHotels = new Hotel[temHotels.size()];
    for(int i = 0; i < temHotels.size(); i++){
      retHotels[i] = temHotels.get(i);
    }
    return retHotels;

  }

  private static boolean isMeetFacility(ArrayList<String> facilities, Hotel hotelRequire) {
    boolean ret = true;
    for (String fa : hotelRequire.facilities) {
      if (!facilities.contains(fa)) {
        ret = false;
        break;
      }
    }
    return ret;
  }

  private static void sort(Hotel[] hotels) {
    Hotel temp;
    for (int i = 0; i < hotels.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (hotels[i] != null && hotels[j] != null) {
          if (hotels[i].getNumberOfFacilities() > hotels[j].getNumberOfFacilities()) {
            temp = hotels[j];
            hotels[j] = hotels[i];
            hotels[i] = temp;
          } else if (hotels[i].getNumberOfFacilities() == hotels[j].getNumberOfFacilities()) {
            if (hotels[i].budget < hotels[j].budget) {
              temp = hotels[j];
              hotels[j] = hotels[i];
              hotels[i] = temp;
            } else if (hotels[i].budget == hotels[j].budget) {
              if (hotels[i].id < hotels[j].id) {
                temp = hotels[j];
                hotels[j] = hotels[i];
                hotels[i] = temp;
              }
            }
          }
        }
      }
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Travel Profiles";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    sc.nextLine();
    Hotel[] hotels = new Hotel[n];
    for (int j = 0; j < n; j++) {
      String[] lines = sc.nextLine().split(" ");
      int id = Integer.parseInt(lines[0]);
      int budget = Integer.parseInt(lines[1]);
      Hotel hotel = new Hotel(id, budget);
      for (int h = 2; h < lines.length; h++) {
        hotel.addFacility(lines[h]);
      }
      hotels[j] = hotel;
    }
    int t = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < t; i++) {
      String[] lines = sc.nextLine().split(" ");
      int budget = Integer.parseInt(lines[0]);
      Hotel hotelRequire = new Hotel(budget);
      for (int h = 1; h < lines.length; h++) {
        hotelRequire.addFacility(lines[h]);
      }
      Hotel[] retHotels = searchHotel(hotels, hotelRequire);
      if (retHotels.length > 0) {
        sort(retHotels);
        for (Hotel h : retHotels) {
          if (h != null) {
            System.out.print(h.id + " ");
          }
        }
      }
      System.out.println("");
    }
  }
}
