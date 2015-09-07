package com.jd.hackerrank;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class FindSubLinkedNode {
  public static class LinkedListNode {
    String val;
    LinkedListNode next;

    LinkedListNode(String node_value) {
      val = node_value;
      next = null;
    }
  };

  public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val) {
    if (head == null) {
      head = new LinkedListNode(val);
    } else {
      LinkedListNode end = head;
      while (end.next != null) {
        end = end.next;
      }
      LinkedListNode node = new LinkedListNode(val);
      end.next = node;
    }
    return head;
  }

  static Stack<String> st = new Stack<String>();
  static boolean match = false;
  static int ret = 0;

  static int find(LinkedListNode list, LinkedListNode sublist) throws Exception {
    if (list == null || sublist == null) {
      if (st.size() == 1) {
        ret = -1;
        return ret;
      }
      ret = st.size() - 1;
      return ret;
    }
    if (Integer.parseInt(list.val) < Integer.parseInt(sublist.val) && !match) {
      find(list.next, sublist);
    } else {
      if (list.val.equals(sublist.val)) {
        st.add(sublist.val);
        match = true;
      } else {
        if (st.size() >= 1) {
          st.pop();
        }
      }
      find(list.next, sublist.next);
    }
    return ret;
  }

  @SuppressWarnings("resource")
  public static void main(String[] args) throws Exception {
    String currentPath = new File(".").getCanonicalPath();
    String fileName = currentPath + "/src/Find Sub Linked Node";
    File file = new File(fileName);

    Scanner sc = new Scanner(file);
    int _list_size = Integer.parseInt(sc.nextLine()), _list_i;
    String _list_item;
    LinkedListNode _list = null;
    for (_list_i = 0; _list_i < _list_size; _list_i++) {
      _list_item = sc.nextLine();
      _list = _insert_node_into_singlylinkedlist(_list, _list_item);
    }

    int _sublist_size = Integer.parseInt(sc.nextLine()), _sublist_i;
    String _sublist_item;
    LinkedListNode _sublist = null;
    for (_sublist_i = 0; _sublist_i < _sublist_size; _sublist_i++) {
      _sublist_item = sc.nextLine();
      _sublist = _insert_node_into_singlylinkedlist(_sublist, _sublist_item);
    }

    int res = find(_list, _sublist);
    System.out.print(res);
  }

}
