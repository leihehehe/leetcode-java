package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class AddStrings {
    public String addStrings(String num1, String num2) {
        int p = num1.length()-1;
        int q = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(p>=0 || q>=0 || carry!=0){
            int a = p>=0? num1.charAt(p)-'0':0;
            int b = q>=0? num2.charAt(q)-'0':0;
            int result = a+b+carry;
            int digit = result%10;
            carry = result/10;
            sb.append(digit);
            p--;
            q--;
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
