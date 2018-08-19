package question1_25;

/**
 * LeetCode question 25 {@see https://leetcode.com/problems/reverse-nodes-in-k-group/description/}
 *
 * @author peiheng.zph created on Aug 18, 2018
 * @version 1.0
 */
public class ReverseNodesInKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (k == 1) {
      return head;
    }

    ListNode dummy = new ListNode(0), prev = dummy, first = head, cur = head, nex;
    for (int i = 1; cur != null; i++) {
      if (i % k != 0) {
        cur = cur.next;
        continue;
      }

      prev.next = cur;
      nex = cur.next;
      reverse(first, cur);
      prev = first;
      cur = first = nex;
    }

    prev.next = first;
    return dummy.next;
  }

  private void reverse(ListNode first, ListNode last) {
    ListNode cur = first, prev = null;
    while (cur != last) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    last.next = prev;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) {
    ReverseNodesInKGroup demo = new ReverseNodesInKGroup();
    print(demo.reverseKGroup(build(new int[]{1, 2, 3, 4, 5}), 2));
    print(demo.reverseKGroup(build(new int[]{1, 2, 3, 4, 5}), 3));
  }

  private static ListNode build(int[] array) {
    ListNode dummy = new ListNode(0), prev = dummy;
    for (int i = 0; i < array.length; i++) {
      ListNode node = new ListNode(array[i]);
      prev.next = node;
      prev = node;
    }
    return dummy.next;
  }

  private static void print(ListNode node) {
    if (node == null) {
      return;
    }
    StringBuilder sb = new StringBuilder();
    while (node.next != null) {
      sb.append(node.val).append("->");
      node = node.next;
    }
    sb.append(node.val);
    System.out.println(sb.toString());
  }
}
