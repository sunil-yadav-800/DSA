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
    public boolean hasCycle(ListNode head) {
        return Approach1(head);
    }
    public boolean Approach1(ListNode head)
    {
        HashSet<ListNode> set = new HashSet<>();
        while(head!=null)
        {
            if(set.contains(head))
                return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }
}