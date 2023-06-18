package hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }
        for(int j = 0;j<t.length();j++){
            char c = t.charAt(j);
            count[c-'a']--;
        }
        for(int k = 0;k<count.length;k++){
            if(count[k]!=0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
