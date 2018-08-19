package question1_25;

/**
 * Created by solarknight on 2017/5/15.
 */
public class SwapNodes {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
  }
}
