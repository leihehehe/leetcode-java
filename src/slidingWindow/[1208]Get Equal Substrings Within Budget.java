package slidingWindow;

//leetcode submit region begin(Prohibit modification and deletion)
class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0;
        int curCost = 0;
        int maxLen = 0;
        while(r<s.length()){
            char toAdd = s.charAt(r);
            curCost+=Math.abs(t.charAt(r) - toAdd);
            r++;
            while(curCost>maxCost){
                char toRemove = s.charAt(l);
                curCost -= Math.abs(t.charAt(l) - toRemove);
                l++;
            }
            maxLen = Math.max(r-l,maxLen);
        }
        return maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
