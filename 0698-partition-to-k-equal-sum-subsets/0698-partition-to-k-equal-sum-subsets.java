class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums)
        {
            sum+=num;
        }
        //if sum is not divisible by k than we can't have k subset of equal sum
        if(sum%k!=0)
        {
            return false;
        }
        int target = sum/k;
        return solve(nums,0,0,k,target,new boolean[nums.length]);
    }
    private boolean solve(int[] arr, int idx, int currSum, int k, int target, boolean[] visited)
    {
        //base case
        if(k==0)
        {
            return true;
        }
        if(currSum == target)
        {
            return solve(arr,0,0,k-1,target,visited);
        }
      
        for(int i=idx;i<arr.length;i++)
        {
            if(!visited[i] && currSum+arr[i]<=target)
            {
                visited[i]=true;
                if(solve(arr,i+1,currSum+arr[i],k,target,visited) == true)
                    return true;
                
                visited[i]=false;
            }
        }
        return false;
    }
}