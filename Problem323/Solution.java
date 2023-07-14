class Solution {
    class UnionFind {
        int[] parents;
        int[] ranks;

        UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            while (x != parents[x]) {
                x = parents[x];
            }

            return x;
        }

        int union(int a, int b) {
            int p1 = find(a);
            int p2 = find(b);

            if (p1 != p2) {
                // Path compression.
                if (ranks[p1] > ranks[p2]) {
                    parents[p2] = p1;
                    ranks[p1]++;
                } else {
                    parents[p1] = p2;
                    ranks[p2]++;
                }
                return 1;
            }

            return 0;
        }
    }
    public int countComponents(int n, int[][] edges) {
        int count = n;

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            count -= uf.union(edge[0], edge[1]);
        }

        return count;
    }
}