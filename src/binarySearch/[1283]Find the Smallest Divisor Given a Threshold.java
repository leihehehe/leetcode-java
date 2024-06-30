package binarySearch;

class SmallestDivisorSolution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for(int num:nums){
            max = Math.max(max,num);
        }
        int l = 1, r = max;
        while(l<r){
            int mid = (l+r)/2;
            if(check(nums,mid,threshold)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    public boolean check(int[] nums,int divisor, int threshold){
        int sum = 0;
        for(int num:nums){
            sum+=(num-1)/divisor + 1;
        }
        return sum<=threshold;
    }
}
