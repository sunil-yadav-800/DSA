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
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null)
            return head;
        return Approach1(head,k);
    }
    public ListNode Approach1(ListNode head, int k)
    {
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        k=k%len;
        if(k==0)
            return head;
        
        temp=head;
        for(int i=1;i<len-k;i++)
        {
            temp=temp.next;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        temp=newHead;
        while(temp!=null && temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=head;
        return newHead;
    }
}