class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0;
        int start=0;
        int end=piles.length-1;
        while(start<end)
        {
            end--; //Alice will choose maximum;
            ans+=piles[end]; // i will take 2nd maximum
            end--;
            start++; //bob will take smaller
        }
        return ans;
    }
}