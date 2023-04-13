package trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word:dictionary){
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            String root = getRoot(word, trie.root);
            sb.append(root).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    public String getRoot(String word, TrieNode trieNode){
        TrieNode node = trieNode;
        for(int i =0;i<word.length();i++){
            char letter = word.charAt(i);
            if(node.isWord) return node.word;
            if(!node.children.containsKey(letter)) return word;
            node = node.children.get(letter);
        }
        return word;
    }
    class TrieNode{
        Map<Character,TrieNode> children;
        String word;
        boolean isWord;
        public TrieNode(){
            children = new HashMap<>();
            word=null;
            isWord=false;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root=new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i =0;i<word.length();i++){
                char letter = word.charAt(i);
                if(!node.children.containsKey(letter)){
                    node.children.put(letter,new TrieNode());
                }
                node= node.children.get(letter);
            }
            node.isWord=true;
            node.word=word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
