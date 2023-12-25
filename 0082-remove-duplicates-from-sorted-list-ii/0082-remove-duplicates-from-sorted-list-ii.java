/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode curr=head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.next!=null && curr.val == curr.next.val)
            {
                int value=curr.val;
                while(curr!=null && curr.val == value)
                {
                    curr=curr.next;
                }
            }
            else
            {
                tail.next=curr;
                tail=curr;
                curr=curr.next;
            }
        }
        tail.next=curr;
        return dummy.next;
    }
}