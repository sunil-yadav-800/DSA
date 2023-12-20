class Solution {
    public int findDuplicate(int[] nums) {
        //this problem can be solved using cycle detection approach
        //basically we need to find out the first elemnet of cycle
        
        int slow=0,fast=0;
        //detect loop
        while(true)
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast)
                break;
        }
        //find the starting point of loop
        slow=0;
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow; //slow or fast;
    }
}