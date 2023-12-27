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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        
        if(root==null)
       {
        return list;
       }
    Queue<TreeNode> qq=new LinkedList<>();
    qq.add(root);
    while(!qq.isEmpty())
    {
        int n=qq.size();
        for(int i=1;i<=n;i++)
        {
            TreeNode temp=qq.poll();
             if(i==n)
             {
                 //System.out.print(temp.data+" ");
                 list.add(temp.val);
             }
            if(temp.left!=null)
            {
                qq.add(temp.left);
            }
            if(temp.right!=null)
            {
                qq.add(temp.right);
            }
        }
    }
        return list;
        
  }
    
}