package question1_25;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by solarknight on 2017/5/14.
 */
public class MergeKSortedLists {
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return Integer.compare(o1.val, o2.val);
      }
    });

    for (ListNode node : lists) {
      if (node != null) {
        queue.add(node);
      }
    }

    ListNode dummy = new ListNode(0), cur = dummy;
    while (!queue.isEmpty()) {
      cur.next = queue.poll();
      cur = cur.next;
      if (cur.next != null) {
        queue.add(cur.next);
      }
    }
    return dummy.next;
  }
}
