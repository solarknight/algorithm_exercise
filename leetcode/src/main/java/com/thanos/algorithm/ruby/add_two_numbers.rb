# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    head = ListNode.new(0)
    cur, c1, c2 = head, l1, l2
    carry, sum = 0, 0

    while c1 || c2 || carry != 0
        sum = carry
        if c1 then
            sum += c1.val
            c1 = c1.next
        end
        if c2 then
            sum += c2.val
            c2 = c2.next
        end

        carry, digit = sum.divmod(10)
        cur.next = ListNode.new(digit)
        cur = cur.next
    end

    head.next
end

