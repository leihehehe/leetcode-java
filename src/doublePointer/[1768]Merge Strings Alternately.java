package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(i<word1.length() && j<word2.length()){
            if(count%2==0){
                sb.append(word1.charAt(i));
                i++;
            }else{
                sb.append(word2.charAt(j));
                j++;
            }
            count++;
        }
        while(i<word1.length()){
            sb.append(word1.charAt(i++));
        }
        while(j<word2.length()){
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
