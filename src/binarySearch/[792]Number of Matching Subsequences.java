package binarySearch;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class NumberOfMatchingSubsequence {
    ArrayList<Integer>[] map;
    public int numMatchingSubseq(String s, String[] words) {
        map = new ArrayList[26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map[c-'a']==null){
                map[c-'a'] = new ArrayList<>();
            }
            map[c-'a'].add(i);
        }
        int ans = 0;
        for(String word:words){
            if(isSubsequence(word))
                ans++;
        }
        return ans;

    }
    public boolean isSubsequence(String word){
        int index = 0;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            if(map[c-'a']==null){
                return false;
            }
            int pos = binarySearch(map[c-'a'],index);
            if(pos==-1){
                return false;
            }
            index = pos + 1;
        }
        return true;
    }

    public int binarySearch(ArrayList<Integer> arr, int target){
        int l = 0, r = arr.size()-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr.get(mid)>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(arr.get(l)<target){
            return -1;
        }
        return arr.get(l);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
