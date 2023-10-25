class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left[] = new int[height.length];
        int right[] = new int[height.length];
        //left
        left[0]=height[0];
        for(int i=1;i<height.length;i++)
        {
            left[i]=Math.max(left[i-1],height[i]);
        }
        //right
        right[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
            right[i]=Math.max(right[i+1],height[i]);
        }
        int water=0;
        for(int i=1;i<height.length-1;i++)
        {
            water+=Math.min(left[i],right[i])-height[i];
        }
        return water;
    }
}