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
    public boolean isBalanced(TreeNode root) {
       //return Approach1(root);
        return Approach2(root)!=-1;
    }
    public boolean Approach1(TreeNode root)
    {
        if(root == null)
            return true;
        int lh=height(root.left);
        int rh=height(root.right);
        return Math.abs(lh-rh)<=1 && Approach1(root.left) && Approach1(root.right);
    }
    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return 1+Math.max(lh,rh);
    }
    public int Approach2(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = Approach2(root.left);
        if(left == -1)
            return -1;
        int right = Approach2(root.right);
        if(right == -1)
            return -1;
        
        if(Math.abs(left-right)>1)
            return -1;
        
        return 1+Math.max(left,right);
    }
}