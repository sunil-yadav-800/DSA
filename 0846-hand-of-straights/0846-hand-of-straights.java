class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        return Solve(hand,groupSize);
    }
    public boolean Solve(int[] hand, int groupSize)
    {
        //if size of hand is not multiple of groupSize
        if(hand.length%groupSize!=0)
            return false;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<hand.length;i++)
        {
            //map.put(hand[i],map.getOrDefault(hand[i],0)+1);
            if(map.containsKey(hand[i]))
            {
                map.put(hand[i],map.get(hand[i])+1);
            }
            else
            {
                map.put(hand[i],1);
            }
        }
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++)
        {
            //if already taken number into the group.
            if(map.get(hand[i])<=0)
            {
                continue;
            }
            
            for(int j=0;j<groupSize;j++)
            {
                if(map.containsKey(hand[i]+j) && map.get(hand[i]+j)>0)
                    map.put(hand[i]+j,map.get(hand[i]+j)-1);
                else
                    return false;
            }
        }
        return true;
    }
}