class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0;
        int start=0;
        int end=piles.length-1;
        while(start<end)
        {
            end--;
            ans+=piles[end];
            end--;
            start++;
        }
        return ans;
    }
}