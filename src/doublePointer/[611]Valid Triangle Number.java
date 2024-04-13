package doublePointer;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class TriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        //a+b>c
        //我们固定c，选a和b
        for(int i = 2;i<n;i++){
            int l = 0, r = i-1;
            while(l<r){
                if(nums[l]+nums[r]>nums[i]){
                    res+=r-l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
