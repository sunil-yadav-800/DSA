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
    long value = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return solve(root);
    }
    public boolean solve(TreeNode root)
    {
        if(root == null)
            return true;
        if(solve(root.left)==false)
            return false;
        if(value>=root.val)
           return false;
        
        value = root.val;
        return solve(root.right);
    }
}