package kmp;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle==null || needle.isEmpty()){
            return 0;
        }
        //lps => Longest prefix suffix
        int[] lps =constructLPS(needle);
        int i =0, j = 0;
        while(i<haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            //j reaches the end
            if(j==needle.length()){
                return i-j;
            }
            else if(i<haystack.length() && haystack.charAt(i)!=needle.charAt(j)){
                if(j>0)
                    j = lps[j-1];
                else{
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] constructLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        //i refers to the end of the suffix
        //j refers to the end of the prefix [0,j]
        //comparing pattern[i] and pattern[j], j will be the last index of the longest prefix
        int i = 1, j = 0;
        //AABC
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            }else{
                if(j>0)
                    j = lps[j-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
