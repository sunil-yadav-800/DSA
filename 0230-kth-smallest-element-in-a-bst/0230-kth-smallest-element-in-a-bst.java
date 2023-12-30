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
    public int kthSmallest(TreeNode root, int k) {
        return smallest(root,new int[]{k});
    }
    public int smallest(TreeNode root, int[] k)
    {
        if(root == null)
            return -1;
        
        int left = smallest(root.left,k);
        if(left!=-1)
            return left;
        k[0]--;
        if(k[0]==0)
            return root.val;
        
        return smallest(root.right,k);
        
    }
}