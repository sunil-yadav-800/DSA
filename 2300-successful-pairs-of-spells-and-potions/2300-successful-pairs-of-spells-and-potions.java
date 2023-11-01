class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for(int i=0;i<spells.length;i++)
        {
            ans[i]=findAllPairs(potions,spells[i],success);
        }
        return ans;
    }
    private int findAllPairs(int[] potions, int value, long success)
    {
        int index=potions.length;
        int low=0,high=potions.length-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            long product = (long)potions[mid]*value;
            if(product>=success)
            {
                index=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return potions.length-index;
    }
}