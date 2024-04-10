package weeklyContest.groupedIteration;

//leetcode submit region begin(Prohibit modification and deletion)
class MinCost {
    public int minCost(String colors, int[] neededTime) {
        //abaaaaac
        //si
        //[1,2,3,4,4,5,4,5]
        //first, find the group => composed of the same letter
        //      pointer i(start) => first element of the group
        //      pointer i => last element of the group
        //          colors[i] == colors[i-1]
        //          during finding process, sum up all the letters(need times) in the group
        //          at the same time. record the largest need time
        //      updating ans+= sum - the largest needed time.
        //      i++;

        int i = 0;
        int n = colors.length();
        int res = 0;
        while(i<n){
            int sum = neededTime[i];
            int max = neededTime[i];
            i++;
            while(i<n && colors.charAt(i) == colors.charAt(i-1)){
                sum+=neededTime[i];
                max = Math.max(neededTime[i],max);
                i++;
            }
            res += sum - max;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
