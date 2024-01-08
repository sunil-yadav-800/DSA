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
    public void flatten(TreeNode root) {
        Approach1(root);
    }
    public void Approach1(TreeNode root)
    {
        if(root == null)
            return;
        
        ArrayList<TreeNode> list = new ArrayList<>();
        Preorder(root,list);
        for(int i=0;i<list.size()-1;i++)
        {
            TreeNode node = list.get(i);
            node.left=null;
            node.right=list.get(i+1);
        }
        TreeNode last = list.get(list.size()-1);
        last.left=null;
        last.right=null;
    }
    public void Preorder(TreeNode root, ArrayList<TreeNode> list)
    {
        if(root == null)
            return;
        
        list.add(root);
        Preorder(root.left,list);
        Preorder(root.right,list);
    }
}