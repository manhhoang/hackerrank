package com.jd.hackerrank.cs;

public class LCABinarySearchTree {

  public static Node lca(Node root, Node a, Node b) {
    if (root == null || a == null || b == null) {
      return null;
    }

    if (Math.max(a.data, b.data) < root.data) {
      // both nodes are on the left
      return lca(root.left, a, b);
    } else if (Math.min(a.data, b.data) > root.data) {
      // both nodes are on the right
      return lca(root.right, a, b);
    } else {
      // the nodes are on separate branches
      return root;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
