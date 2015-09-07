package com.jd.hackerrank;

import java.io.File;
import java.util.Calendar;
import java.util.Scanner;

public class CountFridaysthe13th {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Count Fridays the 13-th";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      int startDay = sc.nextInt();
      int startMonth = sc.nextInt();
      int startYear = sc.nextInt();
      Calendar startCal = Calendar.getInstance();
      startCal.set(Calendar.HOUR_OF_DAY, 0);
      startCal.set(Calendar.DAY_OF_MONTH, startDay);
      startCal.set(Calendar.MONTH, startMonth - 1);
      startCal.set(Calendar.YEAR, startYear);

      int endDay = sc.nextInt();
      int endMonth = sc.nextInt();
      int endYear = sc.nextInt();
      Calendar endCal = Calendar.getInstance();
      endCal.set(Calendar.HOUR_OF_DAY, 23);
      endCal.set(Calendar.DAY_OF_MONTH, endDay);
      endCal.set(Calendar.MONTH, endMonth - 1);
      endCal.set(Calendar.YEAR, endYear);

      int count = 0;
      while (startCal.getTime().before(endCal.getTime())) {
        if (startCal.get(Calendar.DAY_OF_WEEK) == 6 && startCal.get(Calendar.DAY_OF_MONTH) == 13) {
          count++;
        }
        startCal.add(Calendar.DAY_OF_MONTH, 1);
      }
      System.out.println(count);
    }

  }

}
