package bitOperation;

//leetcode submit region begin(Prohibit modification and deletion)
class MaximumRequestsSolution1 {

    public int maximumRequests(int n, int[][] requests) {
        int m = requests.length;
        int res = 0;
        for(int i = 0;i<(1<<m);i++){
            //includes all the subsets
            int[] buildings = new int[n];
            int count= 0;
            for(int j = 0;j<m;j++){
                if(((i>>j)&1)==1){
                    buildings[requests[j][0]]--;
                    buildings[requests[j][1]]++;
                    count++;
                }
            }
            if(checkBuildings(buildings)){
                res = Integer.max(res,count);
            }
        }
        return res;

    }
    public boolean checkBuildings(int[] buildings){

        for(int building:buildings){
            if(building!=0) return false;
        }
        return true;
    }
}
class MaximumRequestsSolution2 {
    int[] buildings;
    public int maximumRequests(int n, int[][] requests) {
        buildings = new int[n];

        dfs(0,requests);
        return res;
    }
    int res = 0;
    int count = 0;
    public void dfs(int i, int[][] requests){
        if(i==requests.length){
            boolean valid = true;
            for(int building:buildings){
                if(building!=0){
                    valid=false;
                    break;
                }
            }
            if(valid)
                res = Math.max(count,res);
            return;
        }
        int[] request = requests[i];
        int from = request[0];
        int to = request[1];
        //chosen
        buildings[from]--;
        buildings[to]++;
        count++;
        dfs(i+1,requests);
        count--;
        buildings[from]++;
        buildings[to]--;
        //not chosen
        dfs(i+1,requests);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
