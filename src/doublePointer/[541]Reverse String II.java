package doublePointer;

//leetcode submit region begin(Prohibit modification and deletion)
class ReverseStringII {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for(int i = 0;i<s.length();i+=2*k){
            if(i+k-1<s.length()){
                reverse(arr,i,i+k-1);
            }else{
                reverse(arr,i,s.length()-1);
            }
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int start, int end){
        while(start<end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
