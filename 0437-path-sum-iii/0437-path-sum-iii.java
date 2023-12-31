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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
         int[] ans = new int[]{0};
         allSum(root,(long)targetSum,ans);
         return ans[0];
    }
    public void allSum(TreeNode root, long target, int[] ans)
    {
        if(root == null)
            return;
        
        sum(root,target,ans);
        allSum(root.left,target,ans);
        allSum(root.right,target,ans);
    }
    public void sum(TreeNode root, long target, int[] ans)
    {
        if(root == null)
            return;
        
        if(target == root.val)
             ans[0]++;
        
        sum(root.left,target-root.val,ans);
        sum(root.right,target-root.val,ans);
    }
}