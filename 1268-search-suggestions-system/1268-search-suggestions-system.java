class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode()
    {
        children = new TrieNode[26];
        isWord = false;
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
        for(char c: word.toCharArray())
        {
            int index = c-'a';
            if(node.children[index] == null)
            {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
}
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String word: products)
        {
            trie.insert(word);
        }
        List<List<String>> ans = new ArrayList<>();
        String curr = "";
        for(char c: searchWord.toCharArray())
        {
            curr = curr+c;
            List<String> li = search(trie.root,curr);
            ans.add(li);
        }
        return ans;
    }
    private List<String> search(TrieNode node, String curr)
    {
        List<String> list = new ArrayList<>();
        for(char c: curr.toCharArray())
        {
            int index = c-'a';
            if(node.children[index] == null)
            {
                return list;
            }
            node = node.children[index];
        }
        dfs(node,curr,list);
        return list;
    }
    private void dfs(TrieNode node, String curr, List<String> li)
    {
        if(li.size() == 3)
        {
            return;
        }
        if(node.isWord)
        {
            li.add(curr);
        }
        for(int i=0;i<26;i++)
        {
            if(node.children[i]!=null)
            {
                dfs(node.children[i],curr+(char)(i+'a'),li);
            }
        }
    }
}