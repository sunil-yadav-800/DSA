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
    public ListNode swapNodes(ListNode head, int k) {
        return Approach1(head,k);
    }
    public ListNode Approach1(ListNode head, int k)
    {
        //find length
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }
        //find the kth  node from begining
        ListNode start = head;
        for(int i=0;i<k-1;i++)
        {
            start=start.next;
        }
        //find the kth node from the end
        ListNode end = head;
        for(int i=0;i<len-k;i++)
        {
            end=end.next;
        }
        
        //swap the value
        int tempVal = start.val;
        start.val=end.val;
        end.val=tempVal;
        
        return head;
        
    }
}