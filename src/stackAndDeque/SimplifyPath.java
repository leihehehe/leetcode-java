package stackAndDeque;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * Leetccode 71
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> deque=new ArrayDeque<String>();
        for(String p:paths){
            if(p.equals("") || p.equals(".")) continue;
            if(p.equals("..")){
                if(!deque.isEmpty())
                    deque.removeLast();
            }
            else deque.addLast(p);
        }

        StringBuilder output = new StringBuilder();
        if(deque.isEmpty()) output.append("/");
        while(!deque.isEmpty()){
            String newPath = deque.poll();
            output.append("/"+newPath);
        }
        return output.toString();
    }
}
