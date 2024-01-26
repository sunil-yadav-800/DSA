class Pair{
    String word;
    int step;
    public Pair(String word, int step)
    {
        this.word=word;
        this.step=step;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        return bfs(startGene,endGene,bank);
    }
    public int bfs(String startGene, String endGene, String[] bank)
    {
        HashSet<String> set = new HashSet<>();
        for(String str: bank)
        {
            set.add(str);
        }
        if(!set.contains(endGene))
            return -1;
        
        Queue<Pair> q = new LinkedList<>();
        char[] choice = {'A','C','G','T'};
        q.add(new Pair(startGene,0));
        if(set.contains(startGene))
        {
            set.remove(startGene);
        }
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String word = p.word;
            int step = p.step;
            
            if(word.equals(endGene))
            {
                return step;
            }
            
            for(int i=0;i<word.length();i++)
            {
                for(int j=0;j<choice.length;j++)
                {
                    char[] arr = word.toCharArray();
                    arr[i]=choice[j];
                    String nextWord = new String(arr);
                    if(set.contains(nextWord))
                    {
                        q.add(new Pair(nextWord,step+1));
                        set.remove(nextWord);
                    }
                }
            }
        }
        
        return -1;
    }
}