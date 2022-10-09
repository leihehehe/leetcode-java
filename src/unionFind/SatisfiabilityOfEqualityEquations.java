package unionFind;

/***
 * Leetcode 990
 * Time complexity: O(N + A log A) -> N: the number of equations; A: the number of letters
 * Space complexity: O(A)-> A: the number of letters
 */
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int first = equation.charAt(0) - 'a';
                int second = equation.charAt(3) - 'a';
                union(parent, first, second);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int first = equation.charAt(0) - 'a';
                int second = equation.charAt(3) - 'a';
                if (ifConnected(parent, first, second)) {
                    return false;
                }
            }
        }
        return true;

    }

    public int find(int[] parent, int node) {
        while (node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }

    public void union(int[] parent, int node1, int node2) {
        if (node1 == node2) return;
        parent[find(parent, node1)] = find(parent, node2);
    }

    public boolean ifConnected(int[] parent, int node1, int node2) {
        return find(parent, node1) == find(parent, node2);
    }
}
