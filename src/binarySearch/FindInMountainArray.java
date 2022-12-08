package binarySearch;

import java.util.ArrayList;

/**
 * Leetcode 1095
 */
public class FindInMountainArray {
    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     *     public int get(int index) {}
     *     public int length() {}
     * }
     */

    public int findInMountainArray(int target, MountainArray mountainArr) {
        //[3,4,3,2,1]
        int n = mountainArr.length();
        int l = 0, r = n -1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mountainArr.get(mid)>mountainArr.get(mid+1)) r = mid;
            else l = mid+1;
        }
        int peekIndex = l;
        l = 0;
        r = peekIndex;
        while(l<r){
            int mid = l+(r-l)/2;
            if(mountainArr.get(mid)<target) l = mid+1;
            else r = mid;
        }
        if(mountainArr.get(l)==target) return l;
        else{
            l= peekIndex+1;
            r = n-1;
            while(l<r){
                int mid = l+(r-l)/2;
                if(mountainArr.get(mid)>target) l = mid+1;
                else r = mid;
            }
            if(mountainArr.get(l)==target) return l;
            return -1;
        }
    }
    class MountainArray{
        ArrayList<Integer> arrayList;

        public MountainArray(){
            arrayList = new ArrayList<>();
            arrayList.add(1);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(4);
            arrayList.add(5);
            arrayList.add(3);
            arrayList.add(1);
        }
        public int get(int index) {
            return arrayList.get(index);
        }
        public int length() {
            return arrayList.size();
        }
    }
}
