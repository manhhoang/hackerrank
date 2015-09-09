package com.jd.hackerrank.aiandml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LaptopBatteryLife {

  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/aiandml/trainingdata.txt";

    List<Entry> entries = new ArrayList<Entry>();

    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    String line = "";
    while (line != null) {
      line = br.readLine();
      try {
        String[] values = line.split(",");
        entries.add(new Entry(new Double(values[0]), new Double(values[1])));

      } catch (NullPointerException e) {
        break;
      }
    }
    Collections.sort(entries);
    double max = entries.get(entries.size() - 1).getUse();
    int lines = 0;
    double con = 0;
    for (int i = 0; i < entries.size(); i++) {
      if (entries.get(i).getCharge() != 0) {
        if (entries.get(i).getUse() == max) {
          break;
        } else {
          lines++;
          con += entries.get(i).getUse() / entries.get(i).getCharge();
        }
      }
    }
    con /= lines;

    currentPath = new File(".").getCanonicalPath();
    fileName = currentPath + "/src/aiandml/Laptop Battery Life";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    double input = new Double(sc.nextLine());
    input *= con;
    if (input > max)
      input = max;

    System.out.println(input);
  }

  static class Entry implements Comparable<Entry> {

    private double charge;
    private double use;

    public Entry(double charge, double use) {
      this.charge = charge;
      this.use = use;
    }

    public int compareTo(Entry e) {
      return new Double(use).compareTo(new Double(e.getUse()));
    }

    public void setCharge(double charge) {
      this.charge = charge;
    }

    public double getCharge() {
      return charge;
    }

    public void setUse(double use) {
      this.use = use;
    }

    public double getUse() {
      return use;
    }

  }
}
