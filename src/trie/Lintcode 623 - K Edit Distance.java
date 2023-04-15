package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KEditDistance {
    /**
     * @param words: a set of stirngs
     * @param target: a target string
     * @param k: An integer
     * @return: output all the strings that meet the requirements
     *          we will sort your return value in output
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }
        int n = target.length();
        int[] dp = new int[n+1];
        for(int i = 0;i<=n;i++) dp[i]=i;
        dfs(dp, trie.root, res, target, k);
        return res;
    }
    public void dfs(int[] lastDp, TrieNode node, List<String> res, String target, int k){
        int n = target.length();
        if(node.isWord && lastDp[n]<=k) res.add(node.word);
        for(char letter : node.children.keySet()){
            int[] dpNew = new int[n+1];
            dpNew[0] = lastDp[0]+1;
            for(int j = 1;j<=n;j++){
                if(letter==target.charAt(j-1)) dpNew[j]=lastDp[j-1];
                else dpNew[j] = Math.min(lastDp[j-1]+1,Math.min(lastDp[j]+1,dpNew[j-1]+1));
            }
            dfs(dpNew, node.children.get(letter), res, target, k);
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root= new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(int i = 0;i<word.length();i++){
                char letter = word.charAt(i);
                if(!node.children.containsKey(letter)){
                    node.children.put(letter,new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.isWord=true;
            node.word=word;
        }
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
