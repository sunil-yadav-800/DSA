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
    public int pairSum(ListNode head) {
        int ans=0;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev = reverse(slow);
        slow=head;
        while(rev!=null)
        {
            int sum = slow.val+rev.val;
            ans=Math.max(ans,sum);
            slow=slow.next;
            rev=rev.next;
        }
        return ans;
    }
    public ListNode reverse(ListNode head)
    {
        ListNode curr=head;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}