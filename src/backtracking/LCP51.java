package backtracking;

class PerfectMenu {
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        dfs(0,materials,cookbooks,attribute,limit);
        return res==0?-1:res;
    }
    int res = 0;
    int curFull = 0;
    int curDelicious = 0;
    public void dfs(int cur, int[] materials, int[][] cookbooks, int[][] attribute, int limit){
        //选和不选
        if(cur==cookbooks.length){
            if(curFull>=limit)
                res= Math.max(curDelicious,res);
            return;
        }

        int[] recipes = cookbooks[cur];
        boolean available = true;
        for(int i = 0;i<recipes.length;i++){
            if(recipes[i]>materials[i]){
                available = false;
            }
        }

        if(available){
            //chosen
            for(int i = 0;i<recipes.length;i++){
                materials[i]-= recipes[i];
            }
            curFull+=attribute[cur][1];
            curDelicious+=attribute[cur][0];
            dfs(cur+1,materials,cookbooks,attribute,limit);
            curFull-=attribute[cur][1];
            curDelicious-=attribute[cur][0];
            for(int i = 0;i<recipes.length;i++){
                materials[i]+= recipes[i];
            }
        }

        //not chosen
        dfs(cur+1,materials,cookbooks,attribute,limit);

    }
}