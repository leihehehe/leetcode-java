import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(4&5);
//        System.out.println(solution.countDays(4, new int[][]{{2, 3}, {1, 2},{2,3},{2,4},{1,2},{1,3}}));
    }

}
class Solution1 {

    public int minimumChairs(String s) {
        int count = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='E') count++;
            else count--;
            max = Math.max(max,count);
        }
        return max;
    }
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int freeDays = 0;
        int endOfLastMeeting = 0;

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            // 如果当前会议的开始时间在上一个会议结束之后，说明有空闲时间
            if (start > endOfLastMeeting + 1) {
                freeDays += start - endOfLastMeeting - 1;
            }

            // 更新最后一个会议的结束时间
            endOfLastMeeting = Math.max(endOfLastMeeting, end);
        }

        // 计算最后一个会议结束后的空闲天数
        if (endOfLastMeeting < days) {
            freeDays += days - endOfLastMeeting;
        }

        return freeDays;
    }
    public String clearStars(String s) {
        //删除最后一个字典序最小的数
        //aab*ca***
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>();
        Set<Integer> indexToRemove = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='*'){
                char toRemove = queue.poll();
                ArrayList<Integer> positions = map.get(toRemove);
                indexToRemove.add(positions.get(positions.size()-1));
                positions.remove(positions.size()-1);
            }else{
                if(!map.containsKey(c)){
                    map.put(c,new ArrayList<>());
                }
                map.get(c).add(i);
                queue.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c=  s.charAt(i);
            if(!indexToRemove.contains(i) && c!='*') res.append(c);
        }
        return res.toString();

    }
}