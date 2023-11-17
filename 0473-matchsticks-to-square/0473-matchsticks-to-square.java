class Solution {
    public boolean makesquare(int[] matchsticks) {
        // same as k equal subset sum where k is fixed 1.e k=4
        // time --> O(4*2^n);
        //space --> O(n);
        // n = array length
        int sum=0;
        for(int num: matchsticks)
        {
            sum+=num;
        }
        if(sum%4 !=0)
        {
            return false;
        }
        int target = sum/4;
        return solve(matchsticks,0,0,target,4,new boolean[matchsticks.length]);
    }
    private boolean solve(int[] arr, int idx, int currSum, int target, int k, boolean[] visited)
    {
        //base case
        if(k==0)
        {
            return true;
        }
        if(currSum == target)
        {
            return solve(arr,0,0,target,k-1,visited);
        }
        
        for(int i=idx;i<arr.length;i++)
        {
            if(!visited[i] && currSum+arr[i]<=target)
            {
                visited[i]=true;
                if(solve(arr,i+1,currSum+arr[i],target,k,visited) == true)
                    return true;
                visited[i]=false;
            }
        }
        return false;
    }
}