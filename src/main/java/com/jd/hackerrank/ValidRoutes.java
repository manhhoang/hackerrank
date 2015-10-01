package com.jd.hackerrank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NodeValid {
  public NodeValid(String v) {
    this.v = v;
  }

  public void addAdj(String adj) {
    if (adjs == null) {
      adjs = new ArrayList<String>();
    }
    adjs.add(adj);
  }

  public String v;
  public List<String> adjs;
}

public class ValidRoutes {

  private static NodeValid[] g = new NodeValid[5];

  private static void dfs(){
    
  }
  
  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Valid Routes";
    File file = new File(fileName);
    Scanner sc = new Scanner(file);

    g[0] = new NodeValid("A");
    g[0].addAdj("B");

    g[1] = new NodeValid("B");
    g[1].addAdj("A");
    g[1].addAdj("C");
    g[1].addAdj("C");
    g[1].addAdj("C");
    g[1].addAdj("D");
    g[1].addAdj("D");

    g[2] = new NodeValid("C");
    g[2].addAdj("B");
    g[2].addAdj("B");
    g[2].addAdj("B");
    g[2].addAdj("D");
    g[2].addAdj("D");
    g[2].addAdj("D");

    g[3] = new NodeValid("D");
    g[3].addAdj("C");
    g[3].addAdj("C");
    g[3].addAdj("C");
    g[3].addAdj("B");
    g[3].addAdj("B");

    g[4] = new NodeValid("E");
    g[3].addAdj("D");

    String S = sc.nextLine();
    char[] chars = S.toCharArray();
    for (char c : chars) {

    }
  }
}
