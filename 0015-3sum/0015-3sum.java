class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length-1;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
            {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;
            while(j<k)
            {
                if(nums[i]+nums[j]+nums[k]==0)
                {
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    ans.add(li);
                  
                    
                
                    while((j+1<k) && nums[j+1]==nums[j])
                    {
                        j++;
                    }
                    
                    while((j<k-1) && nums[k]==nums[k-1])
                    {
                        k--;
                    }
                    j++;
                    k--;
                    
                }
                else if(nums[i]+nums[j]+nums[k]>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
            
        }
        return ans;
        
    }
}