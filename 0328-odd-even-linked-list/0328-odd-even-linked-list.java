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
    public ListNode oddEvenList(ListNode head) {
        return solve(head);
    }
    public ListNode solve(ListNode head)
    {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode oddDummy = new ListNode(0);
        ListNode evenDummy = new ListNode(0);
        ListNode oddTail = oddDummy;
        ListNode evenTail = evenDummy;
        ListNode temp=head;
        int count=1;
        while(temp!=null)
        {
            if(count%2 == 0)
            {
                evenTail.next=temp;
                evenTail=temp;
            }
            else
            {
                oddTail.next=temp;
                oddTail=temp;
            }
            count++;
            temp=temp.next;
        }
        
        evenTail.next=null;
        oddTail.next = evenDummy.next;
        
        return oddDummy.next;
    }
}