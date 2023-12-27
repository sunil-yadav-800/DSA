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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return bfs(root);
    }
    public List<List<Integer>> bfs(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag=false;
        q.add(root);
        while(!q.isEmpty())
        {
            int count = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<count;i++)
            {
                TreeNode node = q.poll();
                li.add(node.val);
                
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
                
            }
            if(flag)
                Collections.reverse(li);
            
            ans.add(li);
            flag=!flag;
        }
        return ans;
    }
}