/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     return LCS(root,p,q);   
    }
    public TreeNode LCS(TreeNode root, TreeNode p, TreeNode q)
    {
        //base case
        if(root == null)
            return null;
        
        if(p.val<root.val && q.val<root.val)
            return LCS(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            return LCS(root.right,p,q);
        else
            return root;
    }
}