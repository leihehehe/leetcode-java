package hashtable.hash;

//leetcode submit region begin(Prohibit modification and deletion)
class FirstMissingPositive {
    /**
     * 原地hash
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        //[3,4,-1,1]
        //[-1,4,3,1]
        //[-1,1,3,4]
        //[1,-1,3,4]
        int n = nums.length;
        for(int i = 0;i<n;i++){
            //nums[nums[i]-1] == nums[i]就是判断已经交换好位置了
            //另外这句话还处理了重复元素的情况
            while(nums[i]>=1 && nums[i]-1<n && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }
        for(int i = 0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
