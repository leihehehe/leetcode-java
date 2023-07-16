package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1, j =num2.length()-1;
        int carry = 0;
        while(i>=0 && j>=0){
            int res = (num1.charAt(i)-'0')+(num2.charAt(j)-'0') + carry;
            int digit = res%10;
            carry = res/10;
            sb.append(digit);
            i--;
            j--;
        }
        while(i>=0){
            int res = num1.charAt(i)-'0'+carry;
            int digit = res%10;
            carry = res/10;
            sb.append(digit);
            i--;
        }
        while(j>=0){
            int res = num2.charAt(j)-'0'+carry;
            int digit = res%10;
            carry = res/10;
            sb.append(digit);
            j--;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
