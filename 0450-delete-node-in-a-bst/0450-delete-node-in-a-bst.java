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
    public TreeNode deleteNode(TreeNode root, int key) {
        return solve(root,key);
    }
    public TreeNode solve(TreeNode root, int key)
    {
        if(root == null)
            return null;
        if(key < root.val)
        {
            root.left = solve(root.left,key);
        }
        else if(key > root.val)
        {
            root.right = solve(root.right,key);
        }
        else
        {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else
            {
                //find the right successor
                TreeNode curr = root.right;
                while(curr!=null && curr.left!=null)
                {
                    curr = curr.left;
                }
                //assign value
                root.val = curr.val;
                //delete the successor
                root.right = solve(root.right,root.val);
            }
        }
        return root;
    }
}