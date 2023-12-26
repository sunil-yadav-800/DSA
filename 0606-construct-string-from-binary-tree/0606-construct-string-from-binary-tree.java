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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        String ans = sb.toString();
        ans=ans.substring(1,ans.length()-1);
        return ans;
    }
    public void dfs(TreeNode root, StringBuilder sb)
    {
        if(root == null)
            return;
        sb.append("(");
        sb.append(root.val);
        if(root.left==null && root.right!=null)
            sb.append("()");
        dfs(root.left,sb);
        dfs(root.right,sb);
        sb.append(")");
    }
}