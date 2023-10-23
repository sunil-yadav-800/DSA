class Solution {
    public int[] shuffle(int[] nums, int n) {
     int[] ans = new int[2*n];
        int index=0;
        int start=0,end=n;
        while(end<nums.length)
        {
            ans[index++]=nums[start++];
            ans[index++]=nums[end++];
        }
        return ans;
    }
}