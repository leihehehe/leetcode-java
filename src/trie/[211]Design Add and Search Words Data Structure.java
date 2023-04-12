package trie;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie=new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search(word);
    }
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isWord;
        String word;
        public TrieNode(){
            children = new HashMap<>();
            isWord=false;
            word=null;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i =0;i<word.length();i++){
                char letter = word.charAt(i);
                if(!node.children.containsKey(letter)){
                    node.children.put(letter,new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.isWord=true;
            node.word=word;
        }
        public boolean search(String word){
            return searchWord(root,word,0);
        }
        public boolean searchWord(TrieNode root, String word, int index){
             if(word.length()==index) return root.isWord;
            char letter = word.charAt(index);
            if(letter=='.'){
                for(Character child: root.children.keySet()){
                    if(searchWord(root.children.get(child),word,index+1)) return true;
                }
                return false;
            }
            if(root.children.containsKey(letter))
                return searchWord(root.children.get(letter),word,index+1);
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
