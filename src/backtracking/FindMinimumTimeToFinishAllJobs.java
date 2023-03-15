package backtracking;

import java.util.Arrays;

/**
 * Leetcode 1723
 */
public class FindMinimumTimeToFinishAllJobs {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs,int k) {
        Arrays.sort(jobs);
        reverse(jobs);
        backtrack(jobs,new int[k],0);
        return res;
    }

    private void backtrack(int[] jobs, int[] workloads, int idx) {
        if(jobs.length==idx){
            //after asigning all the jobs, find the maximum working time
            int max = Integer.MIN_VALUE;
            for(int workload:workloads) max = Math.max(workload,max);
            //update the global result
            res = Math.min(max,res);
            return;
        }

        for(int i = 0;i<workloads.length;i++){
            if(workloads[i]+jobs[idx]<res){
                workloads[i]+=jobs[idx];
                backtrack(jobs,workloads,idx+1);
                workloads[i]-=jobs[idx];
                if(workloads[i]==0) break;
            }
        }
    }
    public void reverse(int[] jobs){
        for(int i =0,j=jobs.length-1;i<j;i++,j--){
            int temp = jobs[i];
            jobs[i] = jobs[j];
            jobs[j] = temp;
        }
    }
}
