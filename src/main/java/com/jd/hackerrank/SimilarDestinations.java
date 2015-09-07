package com.jd.hackerrank;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Destination {
  public String name = "";
  public List<String> tags;

  public int getNumOfTags() {
    return tags != null ? tags.size() : 0;
  }

  public void addTag(String tag) {
    if (tags == null) {
      tags = new ArrayList<String>();
    }
    tags.add(tag);
  }
}

public class SimilarDestinations {

  private static Map<String, String> mapTags = new HashMap<String, String>();

  private static void sort(List<Destination> retdDes) {
    Destination temp;
    for (int i = 0; i < retdDes.size(); i++) {
      for (int j = 0; j <= i; j++) {
        if (retdDes.get(i) != null && retdDes.get(j) != null) {
          if (retdDes.get(i).getNumOfTags() > retdDes.get(j).getNumOfTags()) {
            temp = retdDes.get(j);
            retdDes.set(j, retdDes.get(i));
            retdDes.set(i, temp);
          } else if (retdDes.get(i).getNumOfTags() == retdDes.get(j).getNumOfTags()) {
            if (retdDes.get(i).name.compareToIgnoreCase(retdDes.get(j).name) < 0) {
              temp = retdDes.get(j);
              retdDes.set(j, retdDes.get(i));
              retdDes.set(i, temp);
            }
          }
        }
      }
    }
  }

  private static String sortName(String name) {
    List<String> ret = new ArrayList<String>();
    String[] names = name.split(",");
    for (String n : names) {
      if (!ret.contains(n)) {
        ret.add(n);
      }
    }
    Collections.sort(ret);
    String retName = "";
    for (String r : ret) {
      retName += r + ",";
    }
    return retName.substring(0, retName.lastIndexOf(","));
  }

  private static void process(List<Destination> des, int n) {
    combineSameGroup(des, n);
    List<Destination> retDes = new ArrayList<Destination>();
    for (Map.Entry<String, String> entry : mapTags.entrySet()) {
      Destination d = new Destination();
      d.name = sortName(entry.getValue());
      String[] tags = entry.getKey().split(",");
      for (String tag : tags) {
        d.addTag(tag);
      }
      retDes.add(d);
    }
    sort(retDes);
    for (Destination d : retDes) {
      System.out.print(d.name + ":");
      String tagStr = "";
      for (String tag : d.tags) {
        tagStr += tag.trim() + ",";
      }
      System.out.print(tagStr.substring(0, tagStr.lastIndexOf(",")));
      System.out.println();
    }
  }

  private static List<Destination> combineSameGroup(List<Destination> des, int n) {
    List<Destination> ret = new ArrayList<Destination>();
    for (int i = 0; i < des.size(); i++) {
      for (int j = i + 1; j < des.size(); j++) {
        if (des.get(i).name.equals(des.get(j).name) && equalLists(des.get(i).tags, des.get(j).tags)) {
          String tagStr = "";
          for (String tag : des.get(i).tags) {
            tagStr += tag.trim() + ",";
          }
          mapTags.put(tagStr, des.get(i).name);
        } else {
          Destination de = combine(des.get(i), des.get(j), n);
          if (de != null) {
            ret.add(de);
          }
        }
      }
    }
    if (ret.size() > 0) {
      ret = combineSameGroup(ret, n);
    }
    return ret;
  }

  public static boolean equalLists(List<String> a, List<String> b) {
    // Check for sizes and nulls
    if ((a.size() != b.size()) || (a == null && b != null) || (a != null && b == null)) {
      return false;
    }

    if (a == null && b == null)
      return true;

    // Sort and compare the two lists
    Collections.sort(a);
    Collections.sort(b);
    return a.equals(b);
  }

  private static Destination combine(Destination des1, Destination des2, int n) {
    Destination retDes = null;
    String combinedNames = "";
    List<String> combinedTags = new ArrayList<String>();
    int count = 0;
    for (String tag : des2.tags) {
      if (des1.tags.contains(tag.trim())) {
        count++;
        if (count == n) {
          combinedNames = des1.name + "," + des2.name;
        }
        combinedTags.add(tag);
      }
    }
    if (count >= n) {
      Collections.sort(combinedTags);
      retDes = new Destination();
      retDes.name += sortName(combinedNames);
      retDes.tags = combinedTags;

      String tagStr = "";
      for (String tag : combinedTags) {
        tagStr += tag.trim() + ",";
      }
      mapTags.put(tagStr, retDes.name);
    }
    return retDes;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Similar Destinations";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    sc.nextLine();
    List<Destination> des = new ArrayList<Destination>();
    while (sc.hasNext()) {
      String[] lines = sc.nextLine().split(":");
      if (lines != null) {
        String name = lines[0];
        Destination d = new Destination();
        d.name = name;
        String[] tags = lines[1].split(",");
        for (String tag : tags) {
          d.addTag(tag);
        }
        des.add(d);
      }
    }
    process(des, n);
  }

}
