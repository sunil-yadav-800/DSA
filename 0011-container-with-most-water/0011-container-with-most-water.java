class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int left=0,right=height.length-1;
        while(left<right)
        {
            int width = right-left;
            int h = Math.min(height[left],height[right]);
            ans = Math.max(ans,width*h);
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return ans;
    }
}