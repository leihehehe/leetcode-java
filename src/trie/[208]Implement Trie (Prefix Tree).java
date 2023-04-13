package trie;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class ImplementTrie {
    TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i =0;i<word.length();i++){
            char letter = word.charAt(i);
            if(!node.children.containsKey(letter))
                node.children.put(letter,new TrieNode());
            node = node.children.get(letter);
        }
        node.isWord=true;
        node.word=word;
    }

    public boolean search(String word) {
        // return searchWord(root,word,0);
        TrieNode node = root;
        for(int i = 0;i<word.length();i++){
            char letter = word.charAt(i);
            if(!node.children.containsKey(letter)) return false;
            node = node.children.get(letter);
        }
        return node.isWord;
    }
    // public boolean searchWord(TrieNode root, String word, int index){
    //     if(word.length()==index) return root.isWord;
    //     char letter = word.charAt(index);
    //     if(letter=='.'){
    //         for(Character child: root.children.keySet()){
    //             return searchWord(root.children.get(child),word,index+1);
    //         }
    //     }
    //     if(root.children.containsKey(letter))
    //         return searchWord(root.children.get(letter),word,index+1);
    //     return false;
    // }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0;i<prefix.length();i++){
            char letter = prefix.charAt(i);
            if(!node.children.containsKey(letter)) return false;
            node = node.children.get(letter);
        }
        return true;
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
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
