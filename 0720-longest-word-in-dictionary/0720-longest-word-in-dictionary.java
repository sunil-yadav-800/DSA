class TrieNode{
    TrieNode[] children;
    String word;
    public TrieNode()
    {
        children = new TrieNode[26];
        word = null;
    }
}
class Trie{
    TrieNode root;
    public Trie()
    {
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode node = root;
        for(char ch: word.toCharArray())
        {
            if(node.children[ch-'a'] == null)
            {
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.word = word;
    }
}
class Solution {
    String result="";
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for(String word: words)
        {
            trie.insert(word);
        }
        dfs(trie.root);
        return result;
    }
    private void dfs(TrieNode node)
    {
        if(node.word!=null)
        {
            if(node.word.length()>result.length())
            {
                result = node.word;
            }
        }
        
        for(int i=0;i<26;i++)
        {
            if(node.children[i]!=null && node.children[i].word!=null)
            {
                dfs(node.children[i]);
            }
        }
    }
}