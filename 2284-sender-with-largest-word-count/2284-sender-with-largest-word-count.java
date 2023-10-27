class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<messages.length;i++)
        {
            String message = messages[i];
            String sender = senders[i];
            int totalWord = countWord(message);
            map.put(sender,map.getOrDefault(sender,0)+totalWord);
        }
        String ans = "";
        int maxValue = 0;
         for (Map.Entry<String,Integer> entry : map.entrySet())
         {
             if(entry.getValue()>=maxValue)
             {
                 if(maxValue == entry.getValue())
                 {
                     if(entry.getKey().compareTo(ans)>=0)
                     {
                         ans=entry.getKey();
                     }
                 }
                 else
                 {
                     ans=entry.getKey();
                 }
                 maxValue = entry.getValue();
             }
         }
        return ans;
    }
    public int countWord(String message)
    {
        int ans = 1;
        while(true)
        {
            int index = message.indexOf(' ');
            if(index==-1)
            {
                break;
            }
            ans++;
            message=message.substring(index+1);
        }
        return ans;
    }
}