class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode()
    {
        children = new TrieNode[26];
        isWord = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray())
        {
            int index = c-'a';
            if(curr.children[index] == null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        return DFS(root,0,word);
    }
    private boolean DFS(TrieNode curr, int idx, String word)
    {
        if(idx == word.length())
        {
            return curr.isWord;
        }
        
        if(word.charAt(idx) == '.')
        {
            for(int i=0;i<26;i++)
            {
                if(curr.children[i]!=null)
                {
                    if(DFS(curr.children[i],idx+1,word)==true)
                        return true;
                }
            }
        }
        else if(curr.children[word.charAt(idx)-'a']!=null)
        {
             if(DFS(curr.children[word.charAt(idx)-'a'],idx+1,word)==true)
                 return true;
        }
        else
        {
            return false;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */