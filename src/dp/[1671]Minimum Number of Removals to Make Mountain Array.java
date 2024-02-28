package dp;

//leetcode submit region begin(Prohibit modification and deletion)
class MinimumMountainRemovalsSolution1 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        //LIS
        int[] up = new int[n];
        //LDS
        int[] down = new int[n];
        up[0] = 1;
        for(int i = 1;i<n;i++){
            int res = 0;
            for(int j =0;j<i;j++){
                if(nums[j]<nums[i])
                    res = Math.max(up[j],res);
            }
            up[i] = res+1;
        }
        down[n-1] = 1;
        for(int i = n-2;i>=0;i--){
            int res = 0;
            for(int j =n-1;j>i;j--){
                if(nums[i]>nums[j])
                    res = Math.max(down[j],res);
            }
            down[i] = res+1;
        }

        int res = 0;
        for(int i = 1;i<n-1;i++){
            //middle point
            //确认两边都有元素
            if(up[i]>1 && down[i]>1){
                res = Math.max(up[i]+down[i]-1,res);
            }

        }
        return n-res;
    }
}
class MinimumMountainRemovalsSolution2 {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        //pre
        int[] dp1 = new int[n];
        dp1[0] = 1;
        int[] arr = new int[n];
        arr[0] = nums[0];
        int j = 0;
        for(int i = 1;i<n;i++){
            if(nums[i]>arr[j]){
                arr[++j] = nums[i];
                dp1[i] = j+1;
            }else{
                int index = binarySearch(arr,0,j,nums[i]);
                arr[index] = nums[i];
                dp1[i] = index+1;
            }
        }

        //post
        int[] dp2 = new int[n];
        dp2[0] = 1;
        int[] nums2 = reverse(nums);
        j=0;
        arr[0] = nums2[0];
        for(int i = 1;i<n;i++){
            if(nums2[i]>arr[j]){
                arr[++j] = nums2[i];
                dp2[i] = j+1;
            }else{
                int index = binarySearch(arr,0,j,nums2[i]);
                arr[index] = nums2[i];
                dp2[i] = index+1;
            }

        }
        dp2 = reverse(dp2);

        //calculate
        int res = 0;
        for(int i =1;i<n-1;i++){
            if(dp1[i]>1 && dp2[i]>1){
                res = Math.max(res,dp2[i]+dp1[i]-1);
            }
        }
        return n-res;
    }

    public int binarySearch(int[] arr, int l, int r, int target){
        while(l<r){
            int mid = l+r>>1;
            if(arr[mid]>=target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public int[] reverse(int[] nums) {
        int n = nums.length;
        int[] reversed = new int[n];
        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }
        return reversed;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
