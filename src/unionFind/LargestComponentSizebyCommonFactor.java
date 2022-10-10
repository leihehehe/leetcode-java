package unionFind;

/***
 * Leetcode 952
 */
public class LargestComponentSizebyCommonFactor {
    public int largestComponentSize(int[] nums) {
        int maxValue=0;
        for(int num:nums){
            maxValue=Math.max(num,maxValue);
        }
        UnionFind unionFind = new UnionFind(maxValue+1);
        for (int num : nums) {
            double upBound = Math.sqrt(num);
            //get all the factors and make them in the same group
            for (int i = 2; i<=upBound; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }

        int[] counts = new int[maxValue + 1];
        int res = 0;
        //find out the group that has largest connected component.
        for (int num : nums) {
            int root = unionFind.find(num);
            counts[root]++;
            res = Math.max(res, counts[root]);
        }
        return res;
    }

    private class UnionFind{
        private int[] parent;
        public UnionFind(int n){
            //initialize the parent nodes
            parent = new int[n];
            for(int i =1;i<n;i++){
                parent[i]=i;
            }
        }
        public int find(int node){
            if(node!=parent[node]){
                parent[node]=find(parent[node]);
            }
            return parent[node];
        }
        public void union(int node1, int node2){
            int root1 = find(node1);
            int root2 = find(node2);
            if(root1==root2) return;
            parent[root1]=root2;
        }
    }
}
