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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return Subtree(root,subRoot);
    }
    public boolean Subtree(TreeNode root, TreeNode subRoot)
    {
        if(subRoot == null)
            return true;
        if(root == null)
            return false;
        
        return (isSametree(root,subRoot) || Subtree(root.left,subRoot) || Subtree(root.right,subRoot));
    }
    public boolean isSametree(TreeNode p, TreeNode q)
    {
        if(p==null && q==null)
            return true;
        if(p==null || q==null || p.val!=q.val)
            return false;
        
        return isSametree(p.left,q.left) && isSametree(p.right,q.right);
    }
}