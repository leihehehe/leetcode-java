package binarySearch;

import java.util.HashMap;
import java.util.Map;

class MedianOfUniquenessArray {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        //子数组个数（首项+末项）*项数/2，求median再-1然后/2
        long midIndex =  (((long)(1+n)*n/2)-1)/2;
        //前k个
        long k = midIndex + 1;
        int l = 0, r = n;
        while(l<r){
            int mid = l+r>>1;
            if(check(mid,k,nums)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    //当uniqueness的频率是x时，是否有>=k个元素
    public boolean check(int x, long k, int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0, r = 0;
        int unique = 0;
        long count = 0;
        //[l,r)
        while(r<nums.length){
            int toAdd = nums[r++];
            map.put(toAdd, map.getOrDefault(toAdd, 0)+1);
            if(map.get(toAdd)==1){
                unique++;
            }
            while(unique>x){
                int toRemove = nums[l++];
                map.put(toRemove, map.get(toRemove)-1);
                if(map.get(toRemove)==0){
                    unique--;
                    map.remove(toRemove);
                }
            }
            count+= r-l;
        }
        return count>=k;
    }
}