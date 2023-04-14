package trie;

import java.util.HashMap;
import java.util.Map;

class MaxDistance {
    /**
     * @param s: the list of binary string
     * @return: the max distance
     */
    public int getAns(String[] s) {
        // Write your code here
        Trie trie = new Trie();
        for(String word:s){
            trie.insert(word);
        }
        return dfs(trie.root);
    }
    //get result
    public int dfs(TrieNode root){
        int res = 0;
        if(root.children.size()==2){
            res=Math.max(res, root.children.get('0').height+root.children.get('1').height+2);
        }
        if(root.isWord) res = Math.max(res,root.height);
        if(root.children.get('0')!=null){
            res = Math.max(res, dfs(root.children.get('0')));
        }
        if(root.children.get('1')!=null){
            res = Math.max(res, dfs(root.children.get('1')));
        }
        return res;
    }
    class TrieNode{
        Map<Character, TrieNode> children;
        String word;
        boolean isWord;
        int height;
        public TrieNode(){
            children = new HashMap<>();
            word=null;
            isWord=false;
            height = 0;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i = 0;i<word.length();i++){
                char letter = word.charAt(i);
                if(!node.children.containsKey(letter)){
                    node.children.put(letter,new TrieNode());
                }
                node = node.children.get(letter);
                node.height = Math.max(node.height, word.length()-i-1);
            }
            node.isWord=true;
            node.word=word;
        }
    }
}
