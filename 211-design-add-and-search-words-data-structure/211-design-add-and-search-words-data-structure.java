class WordDictionary {
    class TrieNode {
        private static final int count = 26;

        private TrieNode[] children;
        private boolean isEnd;

        TrieNode() { this.children = new TrieNode[count]; }
    }

    private static final char a = 'a';
    private static final char dot = '.';
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();    
    }
    
    public void addWord(String word) {
        char[] carr = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < carr.length; i++) {
            if(cur.children[carr[i] - a] == null) cur.children[carr[i] - a] = new TrieNode();
            if(i == carr.length - 1) cur.children[carr[i] - a].isEnd = true;
            cur = cur.children[carr[i] - a];
        }
    }
    
    public boolean search(String word) {
        char[] carr = word.toCharArray();
        return search(root, 0, carr);
    }

    private boolean search(TrieNode cur, int i, char[] carr) {
        if(cur == null) return false;
        if(i == carr.length - 1) {
            if(carr[i] == dot) {
                for(TrieNode child : cur.children) if(child != null && child.isEnd) return true;
                return false;
            }
            if(cur.children[carr[i] - a] == null) return false;
            return cur.children[carr[i] - a].isEnd;
        }
        if(carr[i] == dot) {
            for(TrieNode child : cur.children) if(search(child, i + 1, carr)) return true;
            return false;
        }
        if(cur.children[carr[i] - a] == null) return false;
        return search(cur.children[carr[i] - a], i + 1, carr);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */