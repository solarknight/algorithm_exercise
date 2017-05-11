/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    dummy := &ListNode{0, nil}
    dummy.Next = head
    l1, l2 := dummy, dummy
    for i := 0; i <= n; i++ {
        l2 = l2.Next
    }
    for ; l2 != nil; {
        l1, l2 = l1.Next, l2.Next
    }
    l1.Next = l1.Next.Next;
    return dummy.Next;
}