package bitOperation;

/***
 * acwing 801
 * leetcode
 * offer 15
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            n-=lowbit(n);
            count++;
        }
        return count;
    }

    public int lowbit(int n){
        return n&-n;
    }
}
