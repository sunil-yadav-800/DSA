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
    public void reorderList(ListNode head) {

        // go to the middle of the list using two pointer
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //revese the second half of the list
        ListNode rev = reverse(slow);
        
        ListNode start=head;
        ListNode end = rev;
        while(end!=null)
        {
            ListNode t1=start.next;
            ListNode t2=end.next;
            start.next=end;
            end.next=t1;
            start=t1;
            end=t2;
        }
        if(start!=null)
        {
            start.next=null;
        }
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode next=null;
        while(head!=null)
        {
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}