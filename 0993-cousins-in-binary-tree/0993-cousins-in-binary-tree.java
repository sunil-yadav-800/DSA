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
    public boolean isCousins(TreeNode root, int x, int y) {
        int levelX = level(root,x,1);
        int levelY = level(root,y,1);
        
        return levelX == levelY && !isSibling(root,x,y);
    }
    public int level(TreeNode root, int val, int level)
    {
        if(root == null)
            return 0;
        if(root.val == val)
            return level;
        
        int left = level(root.left,val,level+1);
        if(left!=0)
            return left;
        return level(root.right,val,level+1);
    }
    public boolean isSibling(TreeNode root, int x, int y)
    {
        if(root == null)
            return false;
        
        if(root.left!=null && root.right!=null)
        {
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if((leftVal == x && rightVal ==y) || (leftVal == y && rightVal == x))
                return true;
        }
        return isSibling(root.left,x,y) || isSibling(root.right,x,y);
    }
}