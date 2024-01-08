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
    public int longestZigZag(TreeNode root) {
        int ans[] = new int[]{0};
        count(root,false,0,ans);
        count(root,true,0,ans);
        return ans[0];
    }
    public void count(TreeNode root, boolean takeLeft, int step, int[] ans)
    {
        if(root == null)
            return;
        
        ans[0]=Math.max(ans[0],step);
        if(takeLeft)
        {
            count(root.left,false,step+1,ans);
            count(root.right,true,1,ans);
        }
        else
        {
            count(root.right,true,step+1,ans);
            count(root.left,false,1,ans);
        }
    }
}