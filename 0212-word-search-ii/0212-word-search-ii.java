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
            if(node.children[index]==null)
            {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
}
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words)
        {
            trie.insert(word);
        }
        
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                DFS(i,j,trie.root,"",board,new boolean[board.length][board[0].length],ans);
            }
        }
        return ans;
    }
    private void DFS(int row, int col, TrieNode node, String curr, char[][] board, boolean[][] visited, List<String> ans)
    {
        char c = board[row][col];
        if(visited[row][col] || node.children[c-'a'] == null)
        {
            return;
        }
        node = node.children[c-'a'];
        curr=curr+c;
        if(node.isWord)
        {
            ans.add(curr);
            //to exclude from next time
            node.isWord = false;
        }
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nRow = delRow[i]+row;
            int nCol = delCol[i]+col;
            if(nRow>=0 && nRow<board.length && nCol>=0 && nCol<board[0].length)
            {
                visited[row][col] = true;
                DFS(nRow,nCol,node,curr,board,visited,ans);
                visited[row][col] = false; 
            }
        }
    }
}