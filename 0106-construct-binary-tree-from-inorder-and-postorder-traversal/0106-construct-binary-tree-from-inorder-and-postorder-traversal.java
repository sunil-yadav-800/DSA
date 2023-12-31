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
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        postOrderIndex = postorder.length-1;
        return solve(inorder,postorder,map,0,inorder.length-1);
    }
    public TreeNode solve(int[] inorder, int[] postorder, HashMap<Integer,Integer> map, int inStart, int inEnd)
    {
        if(inStart>inEnd)
            return null;
        
        TreeNode root = new TreeNode(postorder[postOrderIndex--]);
        
        int index = map.get(root.val);
        
        root.right=solve(inorder,postorder,map,index+1,inEnd);
        root.left=solve(inorder,postorder,map,inStart,index-1);
        
        return root;
    }
}