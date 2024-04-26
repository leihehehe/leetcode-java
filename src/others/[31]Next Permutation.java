package others;

//leetcode submit region begin(Prohibit modification and deletion)
class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int p = -1;
        for(int i = n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                p = i;
                break;
            }
        }
        if(p==-1){
            //if we don't find any nums[i]<nums[i+1]
            reverse(nums,0,n-1);
        }else{
            //find the first element that is greater than nums[p]
            for(int i =n-1;i>=0;i--){
                if(nums[i]>nums[p]){
                    swap(nums,p,i);
                    break;
                }
            }
            reverse(nums,p+1,nums.length-1);

        }

    }
    public void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }

    public void reverse(int[] nums, int l, int r){
        while(l<r){

            swap(nums,l,r);
            l++;
            r--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
