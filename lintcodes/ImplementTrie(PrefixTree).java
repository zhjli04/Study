/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/

class Trie {
    TrieNode root = null;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(' ');
     //   root.c
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0){
            return;
        }
        
        TrieNode tn = root;
        for (char c : word.toCharArray()){
            if (tn.children[c - 'a'] == null){
                tn.children[c - 'a'] = new TrieNode(c);
            }
            tn = tn.children[c - 'a'];
        }
        tn.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0){
            return true;
        }
        
        TrieNode tn = root;
        for (char c : word.toCharArray()){
            if (tn.children[c - 'a'] == null){
                return false;
            }
            tn = tn.children[c - 'a'];
        }
        return tn.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0){
            return true;
        }
        
        TrieNode tn = root;
        for (char c : prefix.toCharArray()){
            if (tn.children[c - 'a'] == null){
                return false;
            }
            tn = tn.children[c - 'a'];
        }
        return true;
    }
    
    class TrieNode{
        char c;
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char ch){
            c = ch;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
