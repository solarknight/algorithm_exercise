package question1_25;

/**
 * Created by solarknight on 2017/5/7.
 */
public class RemoveNthNode {

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null) {
      return null;
    }
    ListNode dummy = new ListNode(0), cur1 = dummy, cur2 = dummy;
    dummy.next = head;
    for (int i = 0; i <= n; i++) {
      cur2 = cur2.next;
    }
    while (cur2 != null) {
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    cur1.next = cur1.next.next;
    return dummy.next;
  }

  public static void main(String[] args) {
    RemoveNthNode demo = new RemoveNthNode();
    ListNode head = build(1, 2, 3);
    print(demo.removeNthFromEnd(head, 2));
  }

  private static ListNode build(int... element) {
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    for (int i : element) {
      cur.next = new ListNode(i);
      cur = cur.next;
    }
    return dummy.next;
  }

  private static void print(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
  }
}
