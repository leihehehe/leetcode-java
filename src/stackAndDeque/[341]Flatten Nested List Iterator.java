package stackAndDeque;
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class FlattenNestedListIterator implements Iterator<Integer> {
    LinkedList<NestedInteger> list;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>(nestedList);
    }

    @Override
    public Integer next() {
        return list.remove(0).getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!list.isEmpty() && !list.get(0).isInteger()){
            List<NestedInteger> first = list.remove(0).getList();
            for(int i = first.size()-1;i>=0;i--){
                list.addFirst(first.get(i));
            }
        }
        return !list.isEmpty();
    }
    class NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        public NestedInteger(Integer val) {
            this.val = val;
            this.list = null;
        }
        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
            this.val = null;
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return this.val;
        }

        public List<NestedInteger> getList() {
            return this.list;
        }
    }
}

/**
 * Your stackAndDeque.NestedIterator object will be instantiated and called as such:
 * stackAndDeque.NestedIterator i = new stackAndDeque.NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//leetcode submit region end(Prohibit modification and deletion)
