package com.jd.hackerrank.linked_list;

import org.junit.Assert;
import org.junit.Test;

public class FindSubLinkedNode {

  static class LinkedList {
    int val;
    LinkedList next;

    LinkedList(int node_value) {
      val = node_value;
      next = null;
    }
  };

  private static int count(LinkedList head) {
    int count = 1;
    while (head.next != null) {
      head = head.next;
      count++;
    }
    return count;
  }

  public static LinkedList insert(LinkedList head, int val) {
    if (head == null) {
      head = new LinkedList(val);
    } else {
      LinkedList end = head;
      while (end.next != null) {
        end = end.next;
      }
      LinkedList node = new LinkedList(val);
      end.next = node;
    }
    return head;
  }

  static int find(LinkedList list, LinkedList sublist) {
    LinkedList first = sublist;
    int sourceCount = count(list);
    int targetCount = count(sublist);
    int max = (sourceCount - targetCount);

    for (int i = 0; i <= max; i++) {
      while (list.next != null && list.val != first.val) {
        list = list.next;
        i++;
      }

      if (i <= max) {
        int j = i + 1;
        int end = j + targetCount - 1;
        while (list.next != null && sublist.next != null && j < end
            && list.next.val == sublist.next.val) {
          j++;
          list = list.next;
          sublist = sublist.next;
        }
        list = list.next;
        if (j == end) {
          return i;
        }
      }
    }
    return -1;
  }

  public static int solution(int[] arr, int[] subarr) {
    LinkedList list = null;
    for (int i = 0; i < arr.length; i++) {
      list = insert(list, arr[i]);
    }

    LinkedList sublist = null;
    for (int i = 0; i < subarr.length; i++) {
      sublist = insert(sublist, subarr[i]);
    }
    return find(list, sublist);
  }

  @Test
  public void test1() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 3, 4}));
  }

  @Test
  public void test2() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2, 5, 4}));
  }

  @Test
  public void test3() {
    Assert.assertEquals(3, solution(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5}));
  }

  @Test
  public void test4() {
    Assert.assertEquals(0, solution(new int[] {1, 2, 3, 4, 5}, new int[] {1, 2}));
  }

  @Test
  public void test5() {
    Assert.assertEquals(1, solution(new int[] {1, 2, 3, 4, 5}, new int[] {2}));
  }

  @Test
  public void test6() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4}));
  }

  @Test
  public void test7() {
    Assert.assertEquals(-1, solution(new int[] {1, 2, 3}, new int[] {1, 2, 3, 4, 5}));
  }

  @Test
  public void test8() {
    Assert.assertEquals(2, solution(new int[] {2, 3, 2, 4, 5}, new int[] {2, 4}));
  }
}
