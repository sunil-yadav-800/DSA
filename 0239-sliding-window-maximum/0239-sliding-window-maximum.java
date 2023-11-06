class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int j=0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int i=0;
        while(i<k)
        {
            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()])
            {
                dq.removeLast();
            }
            dq.addLast(i);
            i++;
        }
        ans[j++]=nums[dq.getFirst()];
        while(i<nums.length)
        {
            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()])
            {
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.getFirst()<i-k+1)
            {
                dq.removeFirst();
            }
            ans[j++]=nums[dq.getFirst()];
            i++;
        }
        return ans;
    }
}