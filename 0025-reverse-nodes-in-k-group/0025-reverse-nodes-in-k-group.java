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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode next=null;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode kthNode = findKthNode(temp,k);
            if(kthNode == null)
            {
                if(prev!=null)
                {
                    prev.next=temp;
                    break;
                }
            }
            next=kthNode.next;
            kthNode.next=null;
            reverse(temp);
            if(temp==head)
            {
                head=kthNode;
            }
            else
            {
                prev.next=kthNode;
            }
            prev=temp;
            temp=next;
        }
        return head;
    }
    public ListNode findKthNode(ListNode head, int k)
    {
        ListNode temp=head;
        while(temp!=null && k>1)
        {
            k--;
            temp=temp.next;
        }
        return temp;
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