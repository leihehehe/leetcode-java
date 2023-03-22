package math;

/**
 * Leetcode 263
 */
public class UglyNumber {
    public boolean isUgly(int n) {
        //if n is an ugly number, n = 2^a*3^b*5^c;
        if(n==0) return false;
        int[] factors = new int[]{2,3,5};
        for(int factor:factors){
            while(n%factor==0) n/=factor;
        }
        return n==1;
    }
}
