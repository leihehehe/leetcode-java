package stackAndDeque;

import java.util.*;

class ClearStarsSolution {
    public String clearStars(String s) {
        List<Integer>[] stacks = new ArrayList[26];
        Arrays.setAll(stacks, e -> new ArrayList<>());
        Set<Integer> removed = new HashSet<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '*'){
                for(int j = 0;j<26;j++){
                    if(stacks[j].size()>0){
                        int index = stacks[j].get(stacks.length)-1;
                        stacks[j].remove(stacks.length-1);
                        removed.add(index);
                        break;
                    }
                }
            }else{
                stacks[c-'a'].add(i);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(removed.contains(i) || s.charAt(i)=='*'){
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
