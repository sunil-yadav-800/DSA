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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        sum(root,targetSum,list,ans);
        return ans;
    }
    public void sum(TreeNode root, int target, ArrayList<Integer> list, List<List<Integer>> ans)
    {
        if(root == null)
            return;
        list.add(root.val);
        
        if(target == root.val && root.left==null && root.right==null)
            ans.add(new ArrayList<>(list));
        
        sum(root.left,target-root.val,list,ans);
        sum(root.right,target-root.val,list,ans);
        list.remove(list.size()-1);
    }
}