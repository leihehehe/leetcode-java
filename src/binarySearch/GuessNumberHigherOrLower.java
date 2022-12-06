package binarySearch;

/**
 * Leetcode 374
 */
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        int l = 1, r=n;
        while(l<=r){
            int mid = l+(r-l)/2;
            int res = guess(mid);// guess is a pre-defined API
            if(res==0) return mid;
            if(res==-1) r = mid-1;
            else l = mid +1;
        }
        return l;
    }
}
