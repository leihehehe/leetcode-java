package unionFind;

import java.util.HashMap;
import java.util.Map;

/***
 * Leetcode 128
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        UnionFind unionFind = new UnionFind(nums);
        int res = 1;
        for(int num: nums){
            if(unionFind.contains(num-1)){
                res = Math.max(unionFind.union(num,num-1),res);
            }
            if(unionFind.contains(num+1)){
                res = Math.max(unionFind.union(num,num+1),res);
            }
        }
        return res;
    }
    private class UnionFind{
        Map<Integer,Integer> parents;
        Map<Integer,Integer> sizes;
        public UnionFind(int[] nums){
            int n = nums.length;
            parents = new HashMap<>(n);
            sizes = new HashMap<>(n);
            for(int num:nums){
                parents.put(num,num);
                sizes.put(num,1);
            }
        }
        public int find(int node){
            while(node!=parents.get(node)){
                parents.put(node,parents.get(parents.get(node)));
                node = parents.get(node);
            }
            return node;
        }
        public int union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            int size1 = sizes.get(root1);
            int size2 = sizes.get(root2);
            int sum = size1+size2;
            if(root1==root2) return size1;
            parents.put(root1,root2);
            sizes.put(root2,sum);
            return sum;
        }
        public boolean contains(int node){
            return parents.containsKey(node);
        }
    }
}
