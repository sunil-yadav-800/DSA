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
    public ListNode partition(ListNode head, int x) {
        return solve(head,x);
    }
    public ListNode solve(ListNode head, int x)
    {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        
        ListNode tail1=head1;
        ListNode tail2=head2;
        
        ListNode curr = head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                tail1.next=curr;
                tail1=tail1.next;
            }
            else
            {
                tail2.next=curr;
                tail2=tail2.next;
            }
            curr= curr.next;
        }
        tail1.next=head2.next;
        tail2.next=null;
        
        return head1.next;
    }
}