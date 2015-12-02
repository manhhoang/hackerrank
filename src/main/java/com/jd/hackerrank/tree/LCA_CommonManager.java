package com.jd.hackerrank.tree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class NodeManager {
  public String name;
  public NodeManager right;
  public NodeManager left;

  public NodeManager(String name) {
    this.name = name;
  }

  public void addChild(NodeManager node) {
    if (this.left == null)
      this.left = node;
    else
      this.right = node;
  }
}

public class LCA_CommonManager {

  private static NodeManager addNode(NodeManager node, String parentName, String childName) {
    NodeManager childNode = new NodeManager(childName);
    if (node == null) {
      node = new NodeManager(parentName);
      node.addChild(childNode);
      return node;
    }
    if (node.left != null && node.left.name.equals(parentName)) {
      node.left.addChild(childNode);
      return node;
    } else if (node.right != null && node.right.name.equals(parentName)) {
      node.right.addChild(childNode);
      return node;
    }
    if (node.left != null)
      addNode(node.left, parentName, childName);
    else if (node.right != null)
      addNode(node.right, parentName, childName);

    return node;
  }

  private static NodeManager lca(NodeManager root, NodeManager a, NodeManager b) {
    if (root == null) {
      return null;
    }

    if (root.name.equals(a.name) || root.name.equals(b.name)) {
      // if at least one matched, no need to continue
      // this is the LCA for this root
      return root;
    }

    NodeManager l = lca(root.left, a, b);
    NodeManager r = lca(root.right, a, b);

    if (l != null && r != null) {
      return root; // nodes are each on a separate branch
    }

    // either one node is on one branch,
    // or none was found in any of the branches
    return l != null ? l : r;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Lowest Common Manager";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    sc.nextLine();
    NodeManager a = new NodeManager(sc.nextLine());
    NodeManager b = new NodeManager(sc.nextLine());
    NodeManager root = null;
    while (sc.hasNext()) {
      String str = sc.nextLine();
      if (str.equals("")) {
        break;
      }
      String[] line = str.split(" ");
      String parentName = line[0];
      String childName = line[1];
      root = addNode(root, parentName, childName);
    }

    NodeManager ans = lca(root, a, b);
    System.out.println(ans.name);
  }
}
