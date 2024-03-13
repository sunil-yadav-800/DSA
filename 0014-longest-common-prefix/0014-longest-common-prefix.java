class TrieNode{
    TrieNode[] children;
    int count;
    public TrieNode()
    {
        children = new TrieNode[26];
        count=0;
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
            if(node.children[ch-'a']==null)
            {
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
            node.count++;
        }
    }
}
class Solution {
    String ans = "";
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for(String word: strs)
        {
            trie.insert(word);
        }
        dfs(trie.root,strs.length,"");
        return ans;
    }
    private void dfs(TrieNode node, int len, String curr)
    {
        if(curr.length()>ans.length())
        {
            ans=curr;
        }
        for(int i=0;i<26;i++)
        {
            if(node.children[i]!=null && node.children[i].count == len)
            {
                dfs(node.children[i],len,curr+(char)(i+'a'));
            }
        }
    }
}