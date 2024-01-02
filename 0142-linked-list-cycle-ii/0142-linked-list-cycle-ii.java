/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        return Approach1(head);
    }
    public ListNode Approach1(ListNode head)
    {
        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while(curr!=null)
        {
            if(set.contains(curr))
                return curr;
            set.add(curr);
            curr=curr.next;
        }
        return null;
    }
}