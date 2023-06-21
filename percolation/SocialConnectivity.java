import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SocialConnectivity {
    int[][] social;
    WeightedQuickUnionUF uf;
    int connection_count;

    public SocialConnectivity(int n) {
        uf = new WeightedQuickUnionUF(n);
        social = new int[n][n];
    }

    public boolean allConnected(int p, int q) {
        return connection_count - 1 == social.length;
    }


    public int EarliestTimeAllConnect() {
        // TODO- ? How to get p, q and timestamp as inputs probably using for loop over social array
        while (!allConnected(p, q)) {
            uf.union(p, q);
            connection_count += 1;
        }
        return timestamp;
    }

    public static void main(String[] args) {

    }
}
