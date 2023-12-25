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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;
        if(left==1)
        {
            int position=1;
            ListNode leftNode=head;
            ListNode nextNode = null;
            ListNode curr=head;
            while(curr!=null && position<right)
            {
                curr=curr.next;
                position++;
            }
            ListNode newHead = curr;
            nextNode=curr.next;
            curr.next=null;
            ListNode rev = reverse(head);
            leftNode.next=nextNode;
            return newHead;
        }
        else
        {
            int position=1;
            ListNode prevNode=null;
            ListNode nextNode = null;
            ListNode leftNode = null;
            ListNode rightNode = null;
            ListNode curr=head;
            while(curr!=null && position<right)
            {
                if(position == left-1)
                {
                    prevNode=curr;
                    leftNode=curr.next;
                }
               curr=curr.next;
                position++;
            }
            nextNode = curr.next;
            rightNode = curr;
            curr.next=null;
            ListNode rev = reverse(leftNode);
            prevNode.next=rightNode;
            leftNode.next=nextNode;
            return head;
            
        }
    }
    public ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
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