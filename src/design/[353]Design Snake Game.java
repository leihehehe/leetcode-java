package design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class SnakeGame {
    private Deque<Integer> body = new LinkedList<>();
    private HashSet<Integer> set = new HashSet<>();
    private int width;
    private int height;
    private boolean isAlive;
    //这个food一次只出现一个
    private LinkedList<Integer> food;
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        body.addFirst(encode(0,0));
        set.add(encode(0,0));
        isAlive = true;
        this.food = new LinkedList<>();
        for(int[] f: food){
            this.food.addLast(encode(f[0],f[1]));
        }
    }

    public int encode(int x, int y){
        return x*width+y;
    }


    public int move(String direction) {
        if(!isAlive){
            return -1;
        }

        int head = body.peekFirst();
        int headX = head/width;
        int headY = head%width;
        switch(direction){
            case "U":
                headX--;
                break;
            case "D":
                headX++;
                break;
            case "L":
                headY--;
                break;
            case "R":
                headY++;
                break;
        }
        //超界
        if(headX>=height || headY>=width || headX<0 || headY<0){
            isAlive = false;
            return -1;
        }
        //新位置
        int newCode = encode(headX,headY);
        //要先移动头，再判断尾巴要不要去掉
        body.addFirst(newCode);
        //如果吃了食物，尾巴就不去掉
        if(!food.isEmpty() && food.peekFirst()==newCode){
            food.removeFirst();
        }else{
            set.remove(body.removeLast());
        }
        //touch itself
        if(set.contains(newCode) && newCode != head){
            isAlive = false;
            return -1;
        }
        //所有检查完毕，再添加set
        set.add(newCode);

        return body.size()-1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
//leetcode submit region end(Prohibit modification and deletion)
