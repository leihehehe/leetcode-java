package backtracking;

import java.util.Arrays;

/**
 * Leetcode 473
 */
public class MatchsticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        //4 length -> the same
        int n =4;
        if(matchsticks.length<n) return false;
        int sum = 0;
        for(int i =0;i<matchsticks.length;i++) sum+=matchsticks[i];
        if(sum%n!=0) return false;
        int[] sides = new int[n];
        //ascending
        Arrays.sort(matchsticks);
        //reverse the array to make it descending
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        return backtrack(matchsticks,0,sides,sum/n);
    }

    public boolean backtrack(int[] matchsticks,int index, int[] sides,int targetLen){
        if(index == matchsticks.length) return true;
        for(int i =0;i<sides.length;i++){
            if(sides[i]+matchsticks[index]>targetLen) continue;
            sides[i]+=matchsticks[index];
            if(backtrack(matchsticks,index+1,sides,targetLen)) return true;
            sides[i]-=matchsticks[index];
            if(sides[i]==0) break;
        }
        return false;
    }
}
