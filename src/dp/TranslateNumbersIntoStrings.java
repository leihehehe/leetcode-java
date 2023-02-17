package dp;

/**
 * Offer 46
 */
public class TranslateNumbersIntoStrings {
    /**
     * Method 1: dynamic programming
     * TIME: O(logN) -> n is the number input, and we iterate x times which is the number of digits in that numbers, so it's O(n) ;
     * SPACE: O(logN)
     * @param num
     * @return
     */
    public int translateNum(int num) {
        String str = String.valueOf(num);
        char[] nums = str.toCharArray();
        int n = nums.length;
        if(n<2) return 1;
        int[] dp = new int [n];
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            int sum = (nums[i]-'0')+(nums[i-1]-'0')*10;
            if(sum<26 && sum>9){
                if(i<2) dp[i]=dp[i-1]+1;
                else dp[i]=dp[i-1]+dp[i-2];
            }  else dp[i]=dp[i-1];
        }
        return dp[n-1];
    }

    /**
     * Method 2: dynamic programming using variables to save space.
     * TIME: O(logN) -> n is the number input, and we iterate x times which is the number of digits in that numbers, so it's O(n) ;
     * SPACE: O(logN)
     * @param num
     * @return
     */
    public int translateNumMethod2(int num) {
        String str = String.valueOf(num);
        char[] nums = str.toCharArray();
        int n = nums.length;
        if(n<2) return 1;
        int res = 1, a=0, b=1;
        for(int i = 1;i<n;i++){
            int sum = (nums[i]-'0')+(nums[i-1]-'0')*10;
            if(sum<26 && sum>9){
                if(i<2) res = b+1;
                else res=b+a;
            } else res=b;
            a=b;
            b=res;

        }
        return res;
    }
}
