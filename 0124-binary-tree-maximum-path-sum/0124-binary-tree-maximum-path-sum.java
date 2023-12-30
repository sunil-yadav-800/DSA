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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
         maxSum(root,res);
        
        return res[0];
    }
    public int maxSum(TreeNode root, int[] res)
    {
        if(root == null)
            return Integer.MIN_VALUE;
        
        int left = Math.max(0,maxSum(root.left,res));
        int right = Math.max(0,maxSum(root.right,res));
        res[0]=Math.max(res[0],left+right+root.val);
        return root.val+Math.max(left,right);
    }
}