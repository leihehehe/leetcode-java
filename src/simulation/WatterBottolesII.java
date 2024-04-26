package simulation;

/**
 * Medium
 * Weekly Contest 391
 */
public class WatterBottolesII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        //空瓶子回收来换full water
        //1. drink all the water
        //2. exchange -> 空瓶子来换full water
        // exchange越多，换的full water越多，但是我的空瓶子又依赖于我喝的水
        int empty = numBottles;
        int full = 0;
        int drink = numBottles;
        int exchange = numExchange;

        while(empty>=exchange){
            empty-=exchange;
            exchange++;
            full++;
            if(empty<exchange){
                // drink water
                drink+=full;
                empty+=full;
                full=0;
            }
        }

        return drink;

    }
}
