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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return bfs(beginWord,endWord,wordList);
    }
    public int bfs(String beginWord, String endWord, List<String> wordList)
    {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++)
        {
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord))
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,0));
        if(set.contains(beginWord))
        {
            set.remove(beginWord);
        }
        
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            String word = p.word;
            int step = p.step;
            
            if(word.equals(endWord))
            {
                return step+1;
            }
            
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] arr = word.toCharArray();
                    arr[i]=ch;
                    String nextWord = new String(arr);
                    if(set.contains(nextWord))
                    {
                        q.add(new Pair(nextWord,step+1));
                        set.remove(nextWord);
                    }
                }
            }
        }
        
        return 0;
    }
}