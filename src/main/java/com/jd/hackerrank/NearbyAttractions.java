package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;

class Point {

  public Point(double latitude, double longtitude) {
    this.latitude = latitude;
    this.longitude = longtitude;
  }

  public Point(int id, double latitude, double longtitude) {
    this.id = id;
    this.latitude = latitude;
    this.longitude = longtitude;
  }

  public double dist;
  public int id;
  public double latitude;
  public double longitude;
}

public class NearbyAttractions {

  private static final double PI = 3.14159265359;

  private static double distance_between(Point point1, Point point2) {
    double EARTH_RADIUS = 6371;// in km
    double point1_lat_in_radians = degree2radians(point1.latitude);
    double point2_lat_in_radians = degree2radians(point2.latitude);
    double point1_long_in_radians = degree2radians(point1.longitude);
    double point2_long_in_radians = degree2radians(point2.longitude);

    return Math.acos(Math.sin(point1_lat_in_radians) * Math.sin(point2_lat_in_radians)
        + Math.cos(point1_lat_in_radians) * Math.cos(point2_lat_in_radians)
        * Math.cos(point2_long_in_radians - point1_long_in_radians))
        * EARTH_RADIUS;
  }

  private static double degree2radians(double degree) {
    return degree * PI / 180;
  }

  private static void sort(Point[] points) {
    Point temp;
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j <= i; j++) {
        if (points[i] != null && points[j] != null) {
          if (points[i].dist < points[j].dist) {
            temp = points[j];
            points[j] = points[i];
            points[i] = temp;
          }
          if (points[i].dist == points[j].dist) {
            if (points[i].id < points[j].id) {
              temp = points[j];
              points[j] = points[i];
              points[i] = temp;
            }
          }
        }
      }
    }
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Nearby Attractions";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    sc.nextLine();
    Point[] points = new Point[n];
    for (int j = 0; j < n; j++) {
      String[] cors = sc.nextLine().split(" ");
      int id = Integer.parseInt(cors[0]);
      double latitude = Double.parseDouble(cors[1]);
      double longtitude = Double.parseDouble(cors[2]);
      Point point = new Point(id, latitude, longtitude);
      points[j] = point;
    }
    int t = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < t; i++) {
      String[] lines = sc.nextLine().split(" ");
      double latitude = Double.parseDouble(lines[0]);
      double longtitude = Double.parseDouble(lines[1]);
      Point hotel = new Point(latitude, longtitude);
      String transport = lines[2];
      double hourFrefer = Double.parseDouble(lines[3]) / 60;
      int speed = 0;
      if (transport.equals("metro")) {
        speed = 20;
      } else if (transport.equals("bike")) {
        speed = 15;
      } else {
        speed = 5;
      }
      Point[] retPoint = new Point[n];
      for (int k = 0; k < points.length; k++) {
        double dist = Math.round(distance_between(hotel, points[k]) * 100.0) / 100.0;;
        double hour = dist / speed;
        if (hour <= hourFrefer) {
          retPoint[k] = points[k];
          retPoint[k].dist = dist;
        }
      }
      sort(retPoint);
      for (Point p : retPoint) {
        if (p != null) {
          System.out.print(p.id + " ");
        }
      }
      System.out.println("");
    }
  }
}
