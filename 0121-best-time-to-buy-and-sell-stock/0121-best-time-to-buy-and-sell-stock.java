class Solution {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int ans = 0;
        for(int i=1;i<prices.length;i++)
        {
            minValue = Math.min(minValue,prices[i]);
            ans = Math.max(ans,prices[i]-minValue);
        }
        return ans;
    }
}