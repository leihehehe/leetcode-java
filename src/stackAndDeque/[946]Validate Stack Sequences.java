package stackAndDeque;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int[] stack = new int[1000];
        Arrays.fill(stack, -1);
        int k = -1, j = 0;;
        for(int i = 0;i<pushed.length;i++){
            stack[++k]=pushed[i];
            while(k>=0 && popped[j]==stack[k]){
                stack[k--]=-1;
                j++;
            }
        }
        while(j<popped.length){
            if(stack[k]==popped[j]){
                stack[k--] = -1;
            }
            j++;
        }
        return k==-1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
