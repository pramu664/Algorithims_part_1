/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }


    public static void main(String[] args) {
        // Test client
        QuickUnion id = new QuickUnion(9);
        id.union(1, 0);
        id.union(2, 0);
        id.union(5, 4);
        id.union(6, 4);
        id.union(3, 6);
        boolean result;
        result = id.connected(2, 0);
        // -> true
        result = id.connected(2, 3);
        // -> false
    }
}
