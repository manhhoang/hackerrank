package com.jd.hackerrank.tree.binary_tree;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LCA_CommonManager {

    static class Node {
        public String name;
        public Node right;
        public Node left;

        public Node(String name) {
            this.name = name;
        }

        public void addChild(Node node) {
            if (this.left == null)
                this.left = node;
            else
                this.right = node;
        }
    }

    private static Node addNode(Node node, String parentName, String childName) {
        Node childNode = new Node(childName);
        if (node == null) {
            node = new Node(parentName);
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

    private static Node lca(Node root, Node a, Node b) {
        if (root == null) {
            return null;
        }

        if (root.name.equals(a.name) || root.name.equals(b.name)) {
            // if at least one matched, no need to continue
            // this is the LCA for this root
            return root;
        }

        Node l = lca(root.left, a, b);
        Node r = lca(root.right, a, b);

        if (l != null && r != null) {
            return root; // nodes are each on a separate branch
        }

        // either one node is on one branch,
        // or none was found in any of the branches
        return l != null ? l : r;
    }

    public static void main(String[] args) throws IOException {
        String currentPath = new File(".").getCanonicalPath();
        String fileName = currentPath + "/src/main/data/hackerrank/Lowest Common Manager";
        File file = new File(fileName);

        Scanner sc = new Scanner(file);
        sc.nextLine();
        Node a = new Node(sc.nextLine());
        Node b = new Node(sc.nextLine());
        Node root = null;
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

        Node ans = lca(root, a, b);
        System.out.println(ans.name);
        sc.close();
    }
}
