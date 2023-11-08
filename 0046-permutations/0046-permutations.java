class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
       // List<Integer> list = new ArrayList();
        //solve(nums,0,ans);
        
        Approach2(nums,new boolean[nums.length],ans,new ArrayList<>());
        return ans;
    }
    public void solve(int[] nums, int index, List<List<Integer>> ans)
    {
        if(index == nums.length)
        {
            List<Integer> list = new ArrayList();
            for(int j=0;j<nums.length;j++)
            {
                list.add(nums[j]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(nums,i,index);
            solve(nums,index+1,ans);
            swap(nums,i,index);
        }
    }
    public void swap(int[] nums, int i, int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void Approach2(int[] nums, boolean[] visited, List<List<Integer>> ans, List<Integer> list)
    {
        if(list.size() == nums.length)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i] == false)
            {
                visited[i]=true;
                list.add(nums[i]);
                Approach2(nums,visited,ans,list);
                list.remove(list.size()-1);
                visited[i]=false;
            }
        }
    }
}