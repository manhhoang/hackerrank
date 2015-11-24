package com.jd.hackerrank.cs;

import java.util.ArrayList;
import java.util.List;

class NodeA {
  public String value;

  public NodeA(String value) {
    this.value = value;
  }
}

public class CombinationsMultipleList {

  private static void printSolve(int d, String s, List<ArrayList<NodeA>> list) {
    if (d == list.size()) {
      System.out.println(s.substring(0, s.length() - 1));
      return;
    }
    for (int i = 0; i < list.get(d).size(); i++) {
      printSolve(d + 1, s + list.get(d).get(i).value + " ", list);
    }
    return;
  }

  private static int countSolve(int d, String s, List<ArrayList<NodeA>> list) {
    int count = 0;
    if (d == list.size()) {
      return 1;
    }
    for (int i = 0; i < list.get(d).size(); i++) {
      int c = countSolve(d + 1, s + list.get(d).get(i).value + " ", list);
      count += c;
    }
    return count;
  }

  public static void main(String[] args) {
    List<ArrayList<NodeA>> list = new ArrayList<ArrayList<NodeA>>();

    ArrayList<NodeA> nodes = new ArrayList<NodeA>();
    nodes.add(new NodeA("A1"));
    nodes.add(new NodeA("A2"));
    list.add(nodes);

    nodes = new ArrayList<NodeA>();
    nodes.add(new NodeA("B1"));
    nodes.add(new NodeA("B2"));
    list.add(nodes);

    printSolve(0, "", list);
    System.out.println("Total combination: " + countSolve(0, "", list));
  }

}
