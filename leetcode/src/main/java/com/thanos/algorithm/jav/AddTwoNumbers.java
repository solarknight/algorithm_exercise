package com.thanos.algorithm.jav;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.<br/>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * {@see https://leetcode.com/problems/add-two-numbers/#/description}
 * <p>
 * Created by solarknight on 2017/4/4.
 */
public class AddTwoNumbers {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode(0);
    ListNode cur = head;
    ListNode curL1 = l1;
    ListNode curL2 = l2;

    int carry = 0;
    int sum;
    while (curL1 != null || curL2 != null || carry != 0) {
      sum = (curL1 != null ? curL1.val : 0) + (curL2 != null ? curL2.val : 0) + carry;
      carry = sum / 10;
      cur.next = new ListNode(sum % 10);
      cur = cur.next;
      curL1 = curL1 != null ? curL1.next : null;
      curL2 = curL2 != null ? curL2.next : null;
    }
    return head.next;
  }

}
