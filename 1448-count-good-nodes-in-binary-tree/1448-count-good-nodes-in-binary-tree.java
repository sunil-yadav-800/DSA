/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
   // int maxi=Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        count(root,Integer.MIN_VALUE);
        return ans;
    }
    public void count(TreeNode root, int maxi)
    {
        if(root == null)
            return;
        
        if(root.val>=maxi)
        {
            ans++;
            maxi=Math.max(maxi,root.val);
        }
        
        count(root.left,maxi);
        count(root.right,maxi);
       
    }
}