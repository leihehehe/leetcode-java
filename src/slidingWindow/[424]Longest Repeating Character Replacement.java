package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestRepeatingCharacterReplacement {
    public int characterReplacementMethod1(String s, int k) {
        int[] window = new int[26];
        int l = 0, r = 0;
        int maxCount = 0;
        int maxLen = 0;
        while(r<s.length()){
            char toAdd = s.charAt(r);
            r++;
            window[toAdd-'A'] +=1;
            maxCount = Math.max(maxCount,window[toAdd-'A']);
            //mostFrequent + k < r-l表示不能把窗口内需要替换的字符全部给转换了
            //所以需要缩小窗口，让窗口的长度满足条件
            if(maxCount+k>=(r-l)){
                maxLen = Math.max(maxLen,r-l);
            }
            if(maxCount+k<(r-l)){
                char toRemove = s.charAt(l);
                l++;
                window[toRemove-'A']-=1;
            }

        }
        return maxLen;
    }
    public int characterReplacementMethod2(String s, int k) {
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
