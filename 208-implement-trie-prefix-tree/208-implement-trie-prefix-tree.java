class Trie {

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    private class TrieNode{
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        
    }
    }
    
    public void insert(String word) {
       TrieNode curr = root;
       for(int i=0;i<word.length();i++){
           char c = word.charAt(i);
           int index = c - 'a';
           if(curr.children[index]==null){
               TrieNode node = new TrieNode();
               curr.children[index] = node;
               curr = node;
           }
           else{
               curr = curr.children[index];
           }
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        int length = word.length();
        TrieNode node = root;
        for(int i=0;i<length;i++){
            int index = word.charAt(i) - 'a';
            if(node.children[index]==null){
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        int c;
        for(int i = 0;i<prefix.length();i++){
            c = prefix.charAt(i)-'a';
            if(curr.children[c]==null){
                return false;
            }
            curr = curr.children[c];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */