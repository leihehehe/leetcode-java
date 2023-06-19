package hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(int i = 0;i<magazine.length();i++){
            char c = magazine.charAt(i);
            letters[c-'a']++;
        }
        for(int i = 0;i<ransomNote.length();i++){
            char c = ransomNote.charAt(i);
            letters[c-'a']--;
            if(letters[c-'a']<0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
