class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length==1)
        {
            result.add(nums[0]);
            return result;
        }
        
        int count1=0;
        int count2=0;
        int candidate1=-1;
        int candidate2=-1;
        for(int i=0;i<nums.length;i++)
        {
           if(candidate1 == nums[i])
           {
               count1++;
           }
            else if(candidate2 == nums[i])
            {
                count2++;
            }
            else if(count1 == 0)
            {
                count1=1;
                candidate1=nums[i];
            }
            else if(count2 == 0)
            {
                count2=1;
                candidate2=nums[i];
            }
            else
            {
                count1--;
                count2--;
            }
        }
        
        int c1=0;
        int c2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == candidate1)
            {
                c1++;
            }
            if(nums[i] == candidate2)
            {
                c2++;
            }
        }
        if((candidate1 == candidate2) && (c1>nums.length/3) )
        {
            result.add(candidate1);
            return result;
        }
        if(c1>nums.length/3)
        result.add(candidate1);
        if(c2>nums.length/3)
        result.add(candidate2);
        return result;
    }
}