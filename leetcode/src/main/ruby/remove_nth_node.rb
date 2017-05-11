# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @param {Integer} n
# @return {ListNode}
def remove_nth_from_end(head, n)
    dummy = ListNode.new(0)
    dummy.next = head
    l1, l2 = dummy, dummy
    (n + 1).times {l2 = l2.next}
    while l2
        l1, l2 = l1.next, l2.next
    end
    l1.next = l1.next.next
    return dummy.next
end