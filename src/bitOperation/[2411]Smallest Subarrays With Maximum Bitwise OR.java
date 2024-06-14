package bitOperation;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class SmallestSubarraysSolution {
    public int[] smallestSubarrays(int[] nums) {
        var n = nums.length;
        var ans = new int[n];
        var ors = new ArrayList<int[]>(); // 按位或的值 + 对应子数组的右端点的最小值
        //注意这道题求的是i为左端点的答案！！！
        //所以只能倒序了
        for (int i = n-1; i >= 0; i--) {
            //i是左端点
            ors.add(new int[]{0, i});
            var k = 0;
            for (var or : ors) {
                //相同的左端点i，or[1]是Or值为or[1]时最小的右端点
                or[0] |= nums[i];
                if (ors.get(k)[0] == or[0])
                    ors.get(k)[1] = or[1]; // 合并相同值，右端点下标取最小的，在or中，右端点是越变越小的，因为是倒叙遍历，加入or中都是越变越小的。
                else ors.set(++k, or);
            }
            ors.subList(k + 1, ors.size()).clear();
            //Or值最大的最小右端点- 左端点 +1
            //Or值是数越多越大，所以明显是最先被存储进去的or会最大（因为后面不停的被or）。
            ans[i] = ors.get(0)[1] - i + 1 ;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
