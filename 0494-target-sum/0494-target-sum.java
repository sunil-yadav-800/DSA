class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return solve(nums,0,target);
    }
    private int solve(int[] arr, int idx, int target)
    {
        if(idx == arr.length)
        {
            if(target == 0)
                return 1;
            
            return 0;
        }
        int plus = solve(arr,idx+1,target+arr[idx]);
        int minus = solve(arr,idx+1,target-arr[idx]);
        return plus+minus;
    }
}