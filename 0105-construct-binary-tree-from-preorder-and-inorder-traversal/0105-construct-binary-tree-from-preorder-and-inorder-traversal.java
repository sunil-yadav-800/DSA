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
    int preorderIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        return solve(preorder,inorder,map,0,inorder.length-1);
    }
    public TreeNode solve(int[] preorder, int[] inorder, HashMap<Integer,Integer> map, int inStart, int inEnd)
    {
        if(inStart>inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preorderIndex++]);
        int index = map.get(root.val);
        
        root.left = solve(preorder,inorder,map,inStart,index-1);
        root.right = solve(preorder,inorder,map,index+1,inEnd);
        return root;
    }
}