package graph;

import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms,0,1);
        for(boolean v:visited){
            if(!v){
                return false;
            }
        }
        return true;

    }
    private boolean[] visited;
    public void dfs(List<List<Integer>> rooms, int curRoom, int len){
        //base
        visited[curRoom] = true;
        List<Integer> unlockedRooms = rooms.get(curRoom);
        for(int i = 0;i<unlockedRooms.size();i++){
            int room = unlockedRooms.get(i);
            if(visited[room]){
                continue;
            }
            dfs(rooms,room,len+1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
