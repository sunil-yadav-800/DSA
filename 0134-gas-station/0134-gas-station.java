class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //return NaiveApproach(gas,cost);
        
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++)
        {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalCost>totalGas)
            return -1;
        
        int startingIndex = 0;
        totalGas=0;
        for(int i=0;i<gas.length;i++)
        {
            totalGas+=gas[i]-cost[i];
            if(totalGas<0)
            {
                totalGas=0;
                startingIndex=i+1;
            }
        }
        return startingIndex;
        
    }
    
    //brute force
    
    public int NaiveApproach(int[] gas, int[] cost)
    {
        for(int i=0;i<gas.length;i++)
        {
            boolean flag = true;
            int totalGas=0;
            for(int j=0;j<gas.length;j++)
            {
                totalGas = totalGas + gas[(j+i)%gas.length] - cost[(j+i)%gas.length];
                if(totalGas<0)
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
                return i;
        }
        return -1;
    }
}