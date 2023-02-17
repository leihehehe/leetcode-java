package dp;

/**
 * Leetcode 91
 */
public class DecodeWays {
    /**
     * Method 1: dynamic programming
     */
    public int numDecodings(String s) {
        char[] nums = s.toCharArray();
        //2     2     6
        //i-2  i-1    i
        //A(i) = A(i-1)*1 +A(i-2)*1 -> Xi-1Xi is valid and Xi-1 is not equal to 0
        //A(i) = A(i-1)*1 +A(i-2)*0 ->Xi-1 Xi is invalid, and Xi is not equal to 0
        //A(i) = A(i-1)*0 +A(i-2)*1 ->Xi-1 Xi is valid, and Xi is equal to 0
        //A(i) = A(i-1)*0 +A(i-2)*0 ->Xi-1 Xi is invalid, and Xi is not equal to 0
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0]= 1;
        for(int i = 1;i<n+1;i++){
            if(nums[i-1]!='0'){
                dp[i] += dp[i-1];
            }
            if(i>1){
                int sum = (nums[i-1]-'0')+(nums[i-2]-'0')*10;
                if(sum<=26 && sum>9)
                    dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
    /**
     * Method 2: dynamic programming using variables to save space.
     * PS: It's better to use s.charAt() to save the space complexity O(N) -> method 3
     * @param s
     * @return
     */
    public int numDecodingsMethod2(String s) {
        char[] nums = s.toCharArray();
        //2     2     6
        //i-2  i-1    i
        //A(i) = A(i-1)*1 +A(i-2)*1 -> Xi-1Xi is valid and Xi-1 is not equal to 0
        //A(i) = A(i-1)*1 +A(i-2)*0 ->Xi-1 Xi is invalid, and Xi is not equal to 0
        //A(i) = A(i-1)*0 +A(i-2)*1 ->Xi-1 Xi is valid, and Xi is equal to 0
        //A(i) = A(i-1)*0 +A(i-2)*0 ->Xi-1 Xi is invalid, and Xi is not equal to 0
        int n = nums.length;
        int a =0, b = 1, res = 0;
        for(int i = 1;i<n+1;i++){
            // a = A[i-2], b = A[i-1], res=A[i]
            res = 0;//remember to make it 0 because A[i] is inilized to 0
            if(nums[i-1]!='0'){
                res += b;
            }
            if(i>1){
                int sum = (nums[i-1]-'0')+(nums[i-2]-'0')*10;
                if(sum<=26 && sum>9)
                    res+=a;
            }
            a=b;
            b=res;
        }
        return res;
    }

    /**
     * Method 3: Use the inbuilt function charAt() to reduce the space complexity.
     * @param s
     * @return
     */
    public int numDecodingsMethod3(String s) {
        int n = s.length();
        //F(i) += F(i-1) -> Xi not zero
        //F(i) += F(i-2) -> Xi-1 Xi valid
        int[] dp = new int[n+1];
        dp[0]=1;
        for(int i =1;i<n+1;i++){
            if(s.charAt(i-1)!='0') dp[i]+=dp[i-1];
            if(i>1){
                int sum = (s.charAt(i-1)-'0')+(s.charAt(i-2)-'0')*10;
                if(sum<27 && sum>9) dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
