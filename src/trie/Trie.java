package trie;

public class Trie {
    private TrieNode root;
    public Trie(){
        root= new TrieNode();
    }
    public TrieNode getRoot() {
        return root;
    }

    /**
     * O(M) -> M: the length of the word
     * @param word
     */
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

    public boolean search(String word){
        return searchWord(root,word,0);
    }

    boolean searchWord(TrieNode root, String word, int index){
        if(index==word.length()) return root.isWord;
        char letter = word.charAt(index);
        if(letter=='.'){
            for(Character child:root.children.keySet()){
                //if children can find the rest of the characters
                if(searchWord(root.children.get(child),word,index+1)) return true;
            }
            return false;
        }
        //not `.`
        if(root.children.containsKey(letter))
            return searchWord(root.children.get(letter),word,index+1);
        return false;
    }

}
