package bitOperation;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumSubarrayLengthSolution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        List<int[]> leftToOr = new ArrayList<>();
        for(int i =0;i<n;i++){
            //right
            leftToOr.add(new int[]{i,0});
            //原地去重，双指针。j用于指向最后一个不重复的有效数字,下面的for循环是省略了i
            int j = 0;
            for(int x = 0;x<leftToOr.size();x++){
                int[] pair = leftToOr.get(x);
                pair[1]|=nums[i];
                if(pair[1]>=k) res = Math.min(res,i - pair[0]+1);
                //原地去重复
                if(x>0){
                    if(leftToOr.get(j)[1]==pair[1]){
                        leftToOr.get(j)[0]=pair[0];
                    }else{
                        leftToOr.set(++j,pair);
                    }
                }
            }
            leftToOr.subList(j + 1, leftToOr.size()).clear();
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
