package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MinimumAddedIntegerSolution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //len=1的情况：
        //len!=-1的情况：
        int l = nums2[0] - nums1[m-1];
        int r = nums2[n-1] - nums1[0];
        for(int x = l;x<=r;x++){
            if(check(x,nums1,nums2)) return x;
        }
        return 0;
    }
    public boolean check(int x, int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums2){
            int num1 = num-x;
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        int count = 0;
        for(int num: nums1){
            map.put(num, map.getOrDefault(num,0)-1);
        }
        for(int num: nums2){
            int num1 = num-x;
            if(map.get(num1) <= 0){
                count++;
            }
        }
        return count==nums2.length;

    }
}