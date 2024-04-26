package binarySearch;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Medium
 * Weekly Contest 338
 */
class MinOperations {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        //prefix sum
        long[] arr = new long[n+1];
        //arr[0] = 0;
        //arr[1] = arr[0] + nums[0];
        //arr[2] = arr[1] + nums[1];
        for(int i = 1;i<=n;i++){
            arr[i] = nums[i-1]+ arr[i-1];
        }
        for(int query : queries){
            int index = search(nums, query);
            long left = (long)query * index - arr[index];
            long right = arr[n] - arr[index] - (long)query * (n - index);
            res.add(left + right);
        }
        return res;
    }
    //找第一个大于或等于的数
    public int search(int[] nums, int target){
        int l = 0, r = nums.length;
        while(l < r){
            int mid = l+r>>1;
            if(nums[mid] < target){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // 这里返回的是nums.length，如果target大于所有元素
    }
}
//leetcode submit region end(Prohibit modification and deletion)
