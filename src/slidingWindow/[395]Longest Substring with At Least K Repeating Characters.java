package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestSubstringWithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int res=0;
        for(int i = 1;i<=26;i++){
            res = Math.max(res,longestSubstringWithNCharacters(s,k,i));
        }
        return res;
    }

    public int longestSubstringWithNCharacters(String s, int k, int n){
        int[] window = new int[26];
        int l = 0, r= 0;
        int charactersCount = 0;
        int validCharacters = 0;
        int res = 0;
        while(r<s.length()){
            int toAdd = s.charAt(r)-'a';
            r++;
            if(window[toAdd]==0) charactersCount++;
            window[toAdd]=window[toAdd]+1;
            if(window[toAdd]==k) validCharacters++;
            while(charactersCount>n){
                int toRemove = s.charAt(l)-'a';
                l++;
                if(window[toRemove]==k) validCharacters--;
                window[toRemove]=window[toRemove]-1;
                if(window[toRemove]==0) charactersCount--;
            }
            if(validCharacters==n) res=Math.max(res,r-l);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
