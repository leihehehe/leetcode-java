package binarySearch;

/***
 * Leetcode 275
 */
public class HIndex {
    public int hIndex(int[] citations){
        int len=citations.length;
        if(citations[len-1]==0) return 0;
        int l =0, r = len-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(citations[mid]<len-mid) l = mid +1;
            else r = mid;
        }
        return len-l;
    }
}
