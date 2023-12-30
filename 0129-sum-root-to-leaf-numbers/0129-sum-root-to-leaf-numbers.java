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
    public int sumNumbers(TreeNode root) {
        int[] res = new int[]{0};
        sum(root,0,res);
        return res[0];
    }
    public void sum(TreeNode root, int currSum, int[] res)
    {
        if(root == null)
            return;
        
         currSum=root.val+(currSum*10);
        
        if(root.left==null && root.right==null)
            res[0] = res[0]+currSum;
        
         sum(root.left,currSum,res);
         sum(root.right,currSum,res);
    }
}