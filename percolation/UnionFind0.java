public class UnionFind {
    private int[] id;

    public UnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]) {
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        UnionFind newUF = new UnionFind(10);
        newUF.union(0, 1);
        newUF.union(1, 2);
        newUF.union(2, 3);
        boolean result;
        result = newUF.connected(0, 1);
        result = newUF.connected(8, 9);
    }
}
