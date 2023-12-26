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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solve(root1,root2);
    }
    public TreeNode solve(TreeNode root1, TreeNode root2)
    {
        if(root1==null && root2==null)
            return null;
        int sum=0;
        if(root1!=null)
            sum+=root1.val;
        if(root2!=null)
            sum+=root2.val;
        
        TreeNode root = new TreeNode(sum);
        root.left = solve(root1!=null?root1.left:null,root2!=null?root2.left:null);
        root.right = solve(root1!=null?root1.right:null,root2!=null?root2.right:null);
        return root;
    }
}