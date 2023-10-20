class Solution {
    public int romanToInt(String s) {
        //return Approach1(s);
        return Approach2(s);
    }
    public int Approach1(String s)
    {
        int sum=0;
        if(s.charAt(0)=='I')
        {
            sum=1;
        }
        else if(s.charAt(0)=='V')
        {
            sum=5;
        }
        else if(s.charAt(0)=='X')
        {
            sum=10;
        }
        else if(s.charAt(0)=='L')
        {
            sum=50;
        }
        else if(s.charAt(0)=='C')
        {
            sum=100;
        }
        else if(s.charAt(0)=='D')
        {
            sum=500;
        }
        else
        {
            sum=1000;
        }
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i)=='I')
            {
                sum=sum+1;
            }
            if(s.charAt(i)=='V')
            {
                sum=sum+5;
                if(s.charAt(i-1)=='I')
                {
                    sum=sum-2;
                }
            }
            if(s.charAt(i)=='X')
            {
                sum=sum+10;
                if(s.charAt(i-1)=='I')
                {
                    sum=sum-2;
                }
            }
            
            if(s.charAt(i)=='L')
            {
                sum=sum+50;
                if(s.charAt(i-1)=='X')
                {
                    sum=sum-20;
                }
            }
            
            if(s.charAt(i)=='C')
            {
                sum=sum+100;
                if(s.charAt(i-1)=='X')
                {
                    sum=sum-20;
                }
            }
            
             if(s.charAt(i)=='D')
            {
                sum=sum+500;
                if(s.charAt(i-1)=='C')
                {
                    sum=sum-200;
                }
            }
             if(s.charAt(i)=='M')
            {
                sum=sum+1000;
                if(s.charAt(i-1)=='C')
                {
                    sum=sum-200;
                }
            }
        }
        
        return sum;
        
    }
    public int Approach2(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            if(i<s.length()-1 && map.get(s.charAt(i))<map.get(s.charAt(i+1)))
            {
                ans-=map.get(s.charAt(i));
            }
            else
            {
                ans+=map.get(s.charAt(i));
            }
        }
        return ans;
    }
}