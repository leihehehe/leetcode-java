package backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 698
 */
public class PartitionToKEqualSumSubsets {
    /**
     * Method 1: balls choose buckets
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k>nums.length) return false;
        int sum = 0;
        for(int i = 0;i<nums.length;i++) sum+=nums[i];
        if(sum%k!=0) return false;
        return backtrack(nums,k,0,new int[k],sum/k);
    }
    public boolean backtrack(int[] nums, int k, int index, int[] bucket,int targetSum){
        if(nums.length == index){
            return true;
        }
        for(int i = 0;i<bucket.length;i++){
            if(bucket[i]+nums[index]>targetSum) continue;
            bucket[i]+=nums[index];
            if(backtrack(nums,k,index+1,bucket,targetSum)) return true;
            bucket[i]-=nums[index];
            if(bucket[i]==0) break;
        }
        return false;
    }

    Map<Integer,Boolean> memo = new HashMap<>();

    /**
     * Method 2: buckets choose balls
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsetsMethod2(int[] nums, int k) {
        if(k>nums.length) return false;
        int sum = 0;
        for(int i = 0;i<nums.length;i++) sum+=nums[i];
        if(sum%k!=0) return false;
        return backtrack(nums,k,0,sum/k,0,0);
    }
    public boolean backtrack(int[] nums, int k, int bucketSum, int targetSum,int used, int start){
        if(k==0) return true;
        if(bucketSum == targetSum){
            boolean res = backtrack(nums,k-1,0,targetSum,used,0);
            memo.put(used,res);
            return res;
        }
        if(memo.containsKey(used)) return memo.get(used);
        for(int i = start;i<nums.length;i++){
            if(bucketSum+nums[i]>targetSum) continue;
            if(((used>>i) & 1)==1) continue;
            bucketSum+=nums[i];
            used|=1<<i;
            if(backtrack(nums,k,bucketSum,targetSum,used,start+1)) return true;
            bucketSum-=nums[i];
            used&=~(1<<i) ;
        }
        return false;
    }
}
