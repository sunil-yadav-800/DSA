class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans=0;
        int sum=0;
        int s=0,e=cardPoints.length-1;
        while(e>=0 && e>=cardPoints.length-k)
        {
            sum+=cardPoints[e];
            e--;
        }
        e++;
        ans=sum;
        while(e<cardPoints.length)
        {
            sum+=cardPoints[s]-cardPoints[e];
            ans=Math.max(ans,sum);
            s++;
            e++;
        }
        return ans;
    }
}