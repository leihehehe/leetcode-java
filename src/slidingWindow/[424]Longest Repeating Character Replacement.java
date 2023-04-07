package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l =0, r = 0;
        int[] window = new int[26];
        int countMax = 0;
        int res = 0;
        while(r<s.length()){
            int toAdd = s.charAt(r)-'A';
            r++;
            //update window
            window[toAdd]=window[toAdd]+1;
            //update max count
            countMax = Math.max(window[toAdd],countMax);
            while(r-l-countMax>k){
                int toRemove = s.charAt(l)-'A';
                l++;
                window[toRemove] = window[toRemove]-1;
                if (countMax == window[toRemove]) {
                    countMax--;
                }
            }
            res = Math.max(r-l,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
