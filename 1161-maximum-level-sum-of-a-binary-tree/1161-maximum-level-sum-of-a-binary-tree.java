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
    public int maxLevelSum(TreeNode root) {
        return bfs(root);
    }
    public int bfs(TreeNode root)
    {
        int level=-1;
        int maxSum=Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currLevel=1;
        while(!q.isEmpty())
        {
            int count = q.size();
            int sum=0;
            for(int i=0;i<count;i++)
            {
                TreeNode node = q.poll();
                sum+=node.val;
                
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            if(sum>maxSum)
            {
                maxSum=sum;
                level=currLevel;
            }
            currLevel++;
        }
        return level;
    }
}