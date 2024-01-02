/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return Approach2(head);
    }
    public ListNode Approach1(ListNode head)
    {
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while(curr!=null)
        {
            if(set.contains(curr))
                return curr;
            set.add(curr);
            curr=curr.next;
        }
        return null;
    }
    public ListNode Approach2(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast)
            {
                break;
            }
        }
        if(fast==null || fast.next==null)
        {
            return null;
        }
        slow=head;
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}