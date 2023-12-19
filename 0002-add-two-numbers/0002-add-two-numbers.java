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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return Add(l1,l2);
    }
    public ListNode Add(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum+=l1.val;
            }
            if(l2!=null)
            {
                sum+=l2.val;
            }
            ListNode newNode = new ListNode(sum%10);
            tail.next = newNode;
            tail=newNode; //or tail = tail.next
            carry=sum/10;
            if(l1!=null)
            {
                l1=l1.next;
            }
            if(l2!=null)
            {
                l2=l2.next;
            }
        }
        if(carry>0)
        {
            tail.next=new ListNode(carry);
        }
        return dummy.next;
    }
}