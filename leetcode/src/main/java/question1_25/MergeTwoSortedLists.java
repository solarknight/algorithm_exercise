package question1_25;

/**
 * Created by solarknight on 2017/5/9.
 */
public class MergeTwoSortedLists {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode head = l1.val < l2.val ? l1 : l2;
    head.next = head == l1 ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);
    return head;
  }
}
