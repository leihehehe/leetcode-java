package bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Method 1: bfs
 */
class OpenTheLock1 {
    public int openLock(String[] deadends, String target) {
        Set<String> avoid = new HashSet<>();
        for(String deadend: deadends){
            avoid.add(deadend);
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("0000");

        int turn = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String cur = queue.poll();
                if(avoid.contains(cur))
                    continue;
                avoid.add(cur);
                if(cur.equals(target))
                    return turn;
                for(int j=0;j<4;j++){
                    String upLock = up(cur,j);
                    if(!avoid.contains(upLock)){
                        queue.offer(upLock);
                    }
                    String downLock = down(cur,j);
                    if(!avoid.contains(downLock)){
                        queue.offer(downLock);
                    }
                }
            }
            turn++;
        }
        return -1;
    }

    public String up(String str, int pos){
        char[] ch = str.toCharArray();
        if(ch[pos]=='9') ch[pos]='0';
        else ch[pos]++;
        return new String(ch);
    }

    public String down(String str, int pos){
        char[] ch = str.toCharArray();
        if(ch[pos]=='0') ch[pos]='9';
        else ch[pos]--;
        return new String(ch);
    }
}

/**
 * Method 2: bidirectional bfs
 */
class OpenTheLock2 {
    public int openLock(String[] deadends, String target) {
        Set<String> avoid = new HashSet<>();
        for(String deadend: deadends){
            avoid.add(deadend);
        }
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int turn = 0;
        while(!q1.isEmpty() &&!q2.isEmpty()){
            Set<String> temp = new HashSet<>();
            for(String cur:q1){
                if(avoid.contains(cur))
                    continue;
                if(q2.contains(cur))
                    return turn;
                avoid.add(cur);
                for(int j=0;j<4;j++){
                    String upLock = up(cur,j);
                    if(!avoid.contains(upLock)){
                        temp.add(upLock);
                    }
                    String downLock = down(cur,j);
                    if(!avoid.contains(downLock)){
                        temp.add(downLock);
                    }
                }
            }
            turn++;
            q1=q2;
            q2=temp;
        }
        return -1;
    }

    public String up(String str, int pos){
        char[] ch = str.toCharArray();
        if(ch[pos]=='9') ch[pos]='0';
        else ch[pos]++;
        return new String(ch);
    }

    public String down(String str, int pos){
        char[] ch = str.toCharArray();
        if(ch[pos]=='0') ch[pos]='9';
        else ch[pos]--;
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
