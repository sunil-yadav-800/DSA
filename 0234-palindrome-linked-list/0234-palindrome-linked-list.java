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
    public boolean isPalindrome(ListNode head) {
       
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow);
        slow=head;
        while(rev != null)
        {
            if(rev.val != slow.val)
                return false;
            rev=rev.next;
            slow=slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode curr)
    {
        ListNode prev=null,next=null;
        while(curr != null)
        {
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}