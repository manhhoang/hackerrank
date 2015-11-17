package com.jd.hackerrank.cs;

class Node {
  public int data;
  public Node right;
  public Node left;

  public Node(int data) {
    this.data = data;
  }
}

public class LCABinaryTree {

  public static Node lca(Node root, Node a, Node b) {
    if (root == null) {
      return null;
    }
    if (root.equals(a) || root.equals(b)) {
      // if at least one matched, no need to continue
      // this is the LCA for this root
      return root;
    }
    Node l = lca(root.left, a, b);
    Node r = lca(root.right, a, b);
    if (l != null && r != null) {
      return root; // nodes are each on a seaparate branch
    }
    // either one node is on one branch,
    // or none was found in any of the branches
    return l != null ? l : r;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    Node a = new Node(2);
    Node b = new Node(3);
    root.left = a;
    root.right = b;

    Node node = lca(root, a, b);
    System.out.println(node.data);
  }

}
