package binarySearch;

/***
 * Leetcode 278
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int l = 1, r= n;
        while(l<r){
            int mid = l+(r-l)/2;
            //nums[mid]>=target
            if(isBadVersion(mid)) r=mid;
            else l=mid+1;
        }
        return r;
    }

    public boolean isBadVersion(int num){
        return num > 3;
    }
}
