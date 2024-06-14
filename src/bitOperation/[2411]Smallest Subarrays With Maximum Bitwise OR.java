package bitOperation;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class SmallestSubarraysSolution {
    public int[] smallestSubarrays(int[] nums) {
        var n = nums.length;
        var ans = new int[n];
        var ors = new ArrayList<int[]>(); // 按位或的值 + 对应子数组的右端点的最小值
        //注意这道题求的是i为左端点的答案，所以只能倒序了
        for (int i = n-1; i >= 0; i--) {
            //i是左端点，每次遍历到的新的i也可以成为一个新的数组[i,i]
            ors.add(new int[]{0, i});
            //对已经记录在ors的子数组，为了再扩大它们的左端点范围，需要更新or的值
            for (var or : ors) {
                or[0] |= nums[i];
            }
            //原地去重复，为什么要去重复？
            //我们去重复的时机是发生在每次新遍历到一个左端点i的时候，而这个左端点i可能会出现多个or值相同的子数组。
            //因为ors中我们保存的就是以i为左端点的or值，而且我们要求的是i为左端点时最大or的最小长度，则没有必要保留相同的or值的数组，相反只需要保留一个or值，且保证记录的右端点必须是最小的。
            //原地去重复：
            var k = 0;
            for(var or : ors){
                //or[1]是Or值为or[0]时最小的右端点
                if (ors.get(k)[0] == or[0])
                    ors.get(k)[1] = or[1]; // 合并相同值，右端点下标取最小的，在or中，右端点是越变越小的，因为是倒叙遍历加入的or，ors中的or都是越变越小的。
                else ors.set(++k, or);
            }
            //去完重复k后面的都不要了
            ors.subList(k + 1, ors.size()).clear();
            //Or值最大的最小右端点 - 左端点 +1
            //Or值是数越多越大，所以明显是最先被存储进去的or会最大（因为后面不停的被or）。
            ans[i] = ors.get(0)[1] - i + 1 ;
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
