package design;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SnakeGame1 {
    private Deque<Integer> body = new LinkedList<>();
    private HashSet<Integer> set = new HashSet<>();
    private int width;
    private int height;
    private boolean isAlive;
    //这个food一次只出现一个
    private LinkedList<Integer> food;
    public SnakeGame1(int width, int height, int[][] food) {
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
class SnakeGame2 {
    private LinkedList<Position> body;
    private HashSet<Position> set;
    private int width;
    private int height;
    private boolean alive;
    private Deque<Position> foodPos;
    private int score;
    public SnakeGame2(int width, int height, int[][] food) {
        body = new LinkedList<>();
        body.addLast(new Position(0,0));
        set = new HashSet<>();
        set.add(new Position(0,0));
        this.width = width;
        this.height = height;
        alive = true;
        foodPos = new ArrayDeque<>();
        for(int[] piece: food){
            foodPos.addLast(new Position(piece[1],piece[0]));
        }
        score = 0;
    }
    //returns score of the game after applying one direction move by the snake
    public int move(String direction) {
        if(!alive){
            return -1;
        }
        //check bounds
        Position head = body.getLast();
        int x = head.x;
        int y = head.y;
        switch(direction){
            case "U" -> y = y-1;
            case "R" -> x = x+1;
            case "D" -> y = y+1;
            case "L" -> x = x-1;
        }
        Position curPos = new Position(x,y);
        if(x<0 || x>=width || y<0 || y>=height){
            alive = false;
            return -1;
        }
        Position curFood = foodPos.peekFirst();
        if(curFood!=null && curFood.equals(curPos)){
            //不pop尾巴
            foodPos.pollFirst();
            score++;
        }else{
            Position p = body.removeFirst();
            set.remove(p);
        }
        //碰到body -> 移除蛇尾后检查！
        if(set.contains(curPos)){
            alive = false;
            return -1;
        }
        body.addLast(curPos);
        set.add(curPos);
        return score;
    }
    class Position{
        private int x;
        private int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object pos){
            if(!(pos instanceof Position)){
                return false;
            }
            if(pos == this){
                return true;
            }
            Position p = (Position) pos;
            return p.x==x && p.y ==y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */