package doublePointer;

/**
 * Weekly Contest 391
 * Medium
 */
class CountAlternatingSubarraysSolution1 {
    public long countAlternatingSubarrays(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        //[l,r)
        int prev = -1;
        long res = 0;
        while(r<n){
            int toAdd = nums[r];
            //[1,1,1,0]
            if(prev!=toAdd){
                //继续往后移动
                prev = toAdd;
                r++;
            }else{
                //一样，左移
                long sz = r-l;
                res+= (sz*(sz+1))/2;
                prev = -1;
                l=r;
            }
        }
        //最后可能会漏掉
        long sz = r-l;
        res+= (sz*(sz+1))/2;
        return res;
    }

}
class CountAlternatingSubarraysSolution2 {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        int j = 0;
        long res = 0;
        //[j,i) ->valid subarray
        for(int i = 1;i<n;i++){
            if(nums[i] == nums[i-1]){
                long len = i-j;
                res+=len*(len+1)/2;
                j = i;
            }
        }
        long len = n-j;
        res+=len*(len+1)/2;

        return res;
    }
}