package stackAndDeque.monotonic;

//leetcode submit region begin(Prohibit modification and deletion)
class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder monoStack = new StringBuilder();
        //Deque<Integer> monoStack = new ArrayDeque<>();
        for(int i = 0;i<num.length();i++){
            char c = num.charAt(i);
            while(k>0 && !monoStack.isEmpty() && (monoStack.charAt(monoStack.length()-1)-'a')> c-'a'){
                monoStack.deleteCharAt(monoStack.length()-1);
                k--;
            }
            monoStack.append(c);
        }
        while(!monoStack.isEmpty() && monoStack.charAt(0)=='0'){
            monoStack.deleteCharAt(0);
        }
        while(k>0 && !monoStack.isEmpty()){
            monoStack.deleteCharAt(monoStack.length()-1);
            k--;
        }
        if(monoStack.isEmpty()){
            monoStack.append("0");
        }
        return monoStack.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
