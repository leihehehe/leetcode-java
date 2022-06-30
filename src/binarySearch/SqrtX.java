package binarySearch;

/***
 * Leetcode 69
 */
public class SqrtX {
    public int mySqrt(int x) {
        int l =0, r= x,aws=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if((long)mid*mid<=x){
                l=mid+1;
                aws=mid;
            }else{
                r=mid-1;
            }
        }
        return aws;
    }

}
