import java.util.*;

public class Test {
    public static void main(String[] args) {
//        String s = "[[1,0,0,0,0,0,0,0,1],[0,1,0,1,0,0,0,0,0],[0,0,1,1,0,1,0,0,0],[0,1,1,1,1,0,1,0,0],[0,0,0,1,1,1,0,0,0],[0,0,1,0,1,1,0,0,0],[0,0,0,1,0,0,1,1,0],[0,0,0,0,0,0,1,1,1],[1,0,0,0,0,0,0,1,1]]\n";
//        s = s.replace('[','{').replace(']','}');
//        System.out.println(s);
        Solution1 solution = new Solution1();
        solution.findOriginalArray(new int[]{3,0});

    }

}
class Solution1 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            map.put(changed[i],map.getOrDefault(changed[i], 0)+1);
        }
        int count = n/2;
        int i = n-1, j = 0;
        int[] res = new int[n/2];
        while(i>=0 && count>0){
            if(changed[i]%2==0 && map.get(changed[i])>0 && map.get(changed[i]/2)>0){
                map.put(changed[i],map.getOrDefault(changed[i],0)-1);
                map.put(changed[i]/2,map.getOrDefault(changed[i]/2,0)-1);
                res[j++] = changed[i]/2;
                count--;
            }
            i--;
        }
        return count==0?res:new int[]{};
        //4,8,4
        //2,4,2
        //2,4,2,4,8,4
        //2,2,4,4,4,8

    }
}