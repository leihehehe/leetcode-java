package graph.topologicalSorting;

import java.util.*;

class Solution {
    public String alienOrder(String[] words) {
        //typological sorting
        List<Character>[] graph = new ArrayList[26];
        HashSet<Integer> letters = new HashSet<>();
        Arrays.setAll(graph, e -> new ArrayList<>());
        int[] indegree = new int[26];
        int n = words.length;
        for(String word:words){
            for(char c:word.toCharArray()){
                letters.add(c-'a');
            }
        }
        for(int i = 0 ;i<n-1;i++){
            String word = words[i];
            for(int j = i+1;j<n;j++){
                String nextWord = words[j];
                for(int x = 0;x<100;x++){
                    if(x>=word.length()) break;
                    if(x>=nextWord.length()) return "";
                    char c = word.charAt(x);
                    char next = nextWord.charAt(x);
                    if(c!=next){
                        if(!graph[c-'a'].contains(next)){
                            graph[c-'a'].add(next);
                            indegree[next-'a']++;
                        }
                        break;
                    }

                }

            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i<26;i++){
            if(letters.contains(i) && indegree[i]==0){
                queue.offer(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            int c = queue.poll();
            sb.append((char)(c+'a'));
            for(char next:graph[c]){
                indegree[next-'a']--;
                if(indegree[next-'a']==0) queue.offer(next-'a');
            }
        }
        if(sb.length()==letters.size()){
            return sb.toString();
        }else{
            return "";
        }
    }
}
