class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[]ans=Sum(nums,target);
        return ans;
    }
    public static int[] Sum(int[] arr,int target)
    {
        int[] ans=new int[2];
        HashMap<Integer,Integer> hs=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(hs.containsKey(target-arr[i]))
            {
                ans[0]=i;
                ans[1]=hs.get(target-arr[i]);
                break;
            }
            hs.put(arr[i],i);
        }
        return ans;
    }
}