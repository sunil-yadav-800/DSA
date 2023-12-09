class Solution {
    public int reversePairs(int[] nums) {
        /*
        Naive n = new Naive();
        return n.countReversePairs(nums);
        */
        return MergeSort(nums,0,nums.length-1);
        
    }
    public int MergeSort(int[] nums, int low, int high)
    {
        if(low>=high)
            return 0;
        int mid = (low+high)/2;
        int cnt=0;
        cnt+=MergeSort(nums,low,mid);
        cnt+=MergeSort(nums,mid+1,high);
        cnt+=Merge(nums,low,mid,high);
        return cnt;
    }
    public int Merge(int[] nums, int low, int mid, int high)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i=low,j=mid+1;
        int count=0;
        
        while(i<=mid && j<=high)
        {
            if(nums[i]<=nums[j])
            {
                list.add(nums[i]);
                i++;
            }
            else
            {
                list.add(nums[j]);
                j++;
            }
        }
        while(i<=mid)
        {
            list.add(nums[i]);
            i++;
        }
        while(j<=high)
        {
            list.add(nums[j]);
            j++;
        }
        i=low;
        j=mid+1;
        while(i<=mid && j<=high)
        {
            if((long)nums[i]>2*(long)(nums[j]))
            {
                count+=mid-i+1;
                j++;
            }
            else
            {
                i++;
            }
        }
        
        for(int k=low;k<=high;k++)
        {
            nums[k]=list.get(k-low);
        }
        return count;
    }
    
}
//will give tle
public class Naive{
    public int countReversePairs(int[] nums)
    {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                long ith = (long)(nums[i]);
                long jth = 2*(long)(nums[j]);
                if(ith>jth)
                    ans++;
            }
        }
        return ans;
    }
}