package groupIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class MakeFancyStringSolution1 {
    public String makeFancyString(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while(i<n){
            sb.append(s.charAt(i));
            i++;
            while(i>1 && i<n && s.charAt(i) == s.charAt(i-1) && s.charAt(i) == s.charAt(i-2)){
                i++;
            }
        }
        return sb.toString();
    }
}
class MakeFancyStringSolution2 {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = s.length();
        //这道题分组的定义：该分组不存在连续三个相同的字符
        //leeeeeetcode
        //分组：[lee],[tcode]
        while(i<n){
            //找到分组的开头,如果不是第一个分组，那么就得跳过所有与之前分组的最后一位重复的部分
            while(i>=2&& i<n &&s.charAt(i) == s.charAt(i-1)){
                i++;
            }
            if(i>=n){
                break;
            }
            sb.append(s.charAt(i));
            i++;
            //找到分组的结尾
            while(i>=2&& i<n && !(s.charAt(i) == s.charAt(i-1) && s.charAt(i-1)==s.charAt(i-2))){
                sb.append(s.charAt(i));
                i++;
            }

        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
