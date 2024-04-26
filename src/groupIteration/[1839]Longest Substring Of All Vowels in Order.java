package groupIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class LongestBeautifulSubstring {
    public int longestBeautifulSubstring(String word) {
        char[] next = new char[26];
        next[0] = 'e';
        next['e'-'a'] = 'i';
        next['i'-'a'] = 'o';
        next['o'-'a'] = 'u';
        int i = 0;
        int n = word.length();
        int max = 0;
        while(i<n){
            if(word.charAt(i)!='a'){
                i++;
                continue;
            }
            int start = i;
            i++;
            while(i<n && (word.charAt(i) == next[word.charAt(i-1)-'a'] || word.charAt(i) == word.charAt(i-1))){
                i++;
            }
            if(word.charAt(i-1)=='u'){
                max = Math.max(i-start,max);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
