class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low=1,high=position[position.length-1];
        int ans=0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(isPossible(position,mid,m))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] arr, int force, int m)
    {
        int placedBalls=1;
        int currentBallPosition = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if((arr[i]-currentBallPosition)>=force)
            {
                placedBalls++;
                currentBallPosition = arr[i];
            }
        }
        return placedBalls>=m;
    }
}