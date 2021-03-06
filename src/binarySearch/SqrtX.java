package binarySearch;

/***
 * Leetcode 69
 */
public class SqrtX {
    public int mySqrtMethod1(int x) {
        int l =1, r = x;
        while(l<r){
            int mid =l+(r-l+1)/2;
            if((long)mid*mid > x) r = mid-1;
            else l = mid;
        }
        return r;
    }

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
