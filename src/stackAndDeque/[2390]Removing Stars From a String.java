package stackAndDeque;

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveStarsSolution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(Character c:s.toCharArray()){
            if(c=='*'){
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
