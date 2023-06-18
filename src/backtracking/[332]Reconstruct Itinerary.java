package backtracking;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class ReconstructItinerary {
    List<String> res;
    Map<String,List<String>> graph = new HashMap<>();
    Map<String, boolean[]> used = new HashMap<>();
    boolean finished = false;
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets,(a,b)->a.get(1).compareTo(b.get(1)));
        for (int i = 0;i<tickets.size();i++){
            String departure = tickets.get(i).get(0);
            String arrival = tickets.get(i).get(1);
            graph.putIfAbsent(departure,new LinkedList<>());
            graph.get(departure).add(arrival);
        }
        LinkedList<String> path = new LinkedList<>();
        path.add("JFK");
        backtrack("JFK",path,tickets.size());

        return res;
    }
    public void backtrack(String departure, LinkedList<String> path, int len){
        if(finished)
            return;
        if(path.size()==len+1){
            res = new LinkedList<>(path);
            finished=true;
            return;
        }
        List<String> tickets = graph.get(departure);
        if(tickets==null)
            return;
        used.putIfAbsent(departure,new boolean[tickets.size()]);
        for(int i =0;i<tickets.size();i++){
            boolean[] check = used.get(departure);
            if(check[i]){
                continue;
            }
            String ticket = tickets.get(i);
            path.addLast(ticket);
            check[i]=true;
            backtrack(ticket,path,len);
            path.removeLast();
            check[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
