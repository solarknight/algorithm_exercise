/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    head := &ListNode{0, nil}
    cur := head
    c1 := l1
    c2 := l2

    carry := 0
    sum := 0
    for ; c1 != nil || c2 != nil || carry != 0; {
        sum = carry;
        if c1 != nil {
            sum = sum + c1.Val
            c1 = c1.Next
        }
        if c2 != nil {
            sum = sum + c2.Val
            c2 = c2.Next
        }
        carry = sum / 10
        cur.Next = &ListNode{sum % 10, nil}
        cur = cur.Next
    }
    return head.Next
}