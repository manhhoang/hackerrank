package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FindTheCommonManager {

  private class Node {
    public String name;
    public int level;
    public Node parent;
    public List<Node> children = new ArrayList<Node>();
  }

  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Find The Common Manager";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int n = sc.nextInt();
    sc.nextLine();
    Map<String, Integer> map = new HashMap<String, Integer>();
    String first = sc.nextLine();
    String second = sc.nextLine();
    for (int i = 0; i < n; i++) {
      String[] line = sc.nextLine().split(" ");
      String nodeName = line[0];
      String childName = line[1];
      if (i == 0) {
//        Node node = new Node();
//        node.name = nodeName;
//        Node childNode = new Node();
//        childNode.name = childName;
//        childNode.parent = node;
//        node.children.add(childNode);
//        map.put(nodeName, 1);
      } else {
//        int parentLevel = map.get(parent);
//        map.put(child, parentLevel++);
      }

    }
  }
}
