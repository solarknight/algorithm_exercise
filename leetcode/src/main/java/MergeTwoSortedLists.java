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
    if (l2.val < l1.val) {
      return mergeTwoLists(l2, l1);
    }
    l1.next = mergeTwoLists(l1.next, l2);
    return l1;
  }
}
