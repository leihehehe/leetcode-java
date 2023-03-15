package backtracking;

import java.util.Arrays;

/**
 * Leetcode 2305
 */
public class FairDistributionOfCookies {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        reverse(cookies);
        backtrack(cookies,new int[k],0);
        return res;
    }

    public void backtrack(int[] cookies, int[] childern, int index){
        if(index == cookies.length){
            int max = Integer.MIN_VALUE;
            for(int child: childern) max = Math.max(child,max);
            res = Math.min(max,res);
            return;
        }
        for(int i =0;i<childern.length;i++){
            if(cookies[index]+childern[i]<res){
                childern[i]+=cookies[index];
                backtrack(cookies,childern,index+1);
                childern[i]-=cookies[index];
                if(childern[i]==0) break;
            }
        }
    }
    public void reverse(int[] cookies){
        for(int i =0,j=cookies.length-1;i<j;i++,j--){
            int temp = cookies[i];
            cookies[i]=cookies[j];
            cookies[j]=temp;
        }
    }
}
