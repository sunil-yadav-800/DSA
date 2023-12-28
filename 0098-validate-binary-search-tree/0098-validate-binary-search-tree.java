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
        //return solve(root);
        return Approach2(root,Long.MIN_VALUE,Long.MAX_VALUE);
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
    public boolean Approach2(TreeNode root, long min, long max)
    {
        if(root == null)
            return true;
        
        if(min>=root.val || max<=root.val)
            return false;
        
        boolean left = Approach2(root.left,min,root.val);
        boolean right = Approach2(root.right,root.val,max);
        return left && right;
        
    }
}