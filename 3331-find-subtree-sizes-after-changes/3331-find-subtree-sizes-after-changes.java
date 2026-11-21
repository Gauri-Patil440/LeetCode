
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] ans = new int[n];
        List<Integer>[] path = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            path[i] = new ArrayList<>();
        }

        dfs(0, -1, tree, s, ans, path);

        return ans;
    }

    private void dfs(int node, int par, List<Integer>[] tree,
                    String s, int[] ans, List<Integer>[] path) {

        ans[node] = 1;

        int ch = s.charAt(node) - 'a';

        path[ch].add(node);

        for (int child : tree[node]) {
            dfs(child, node, tree, s, ans, path);
        }

        int newParent = par;

        if (path[ch].size() > 1) {
            newParent = path[ch].get(path[ch].size() - 2);
        }

        if (newParent != -1) {
            ans[newParent] += ans[node];
        }

        path[ch].remove(path[ch].size() - 1);
    }
}
