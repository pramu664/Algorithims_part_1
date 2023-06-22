import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class SocialConnectivity {

    private WeightedQuickUnionUF uf;
    private Connection[] connections;
    private int[] earliestTimes;

    public SocialConnectivity(int n) {
        uf = new WeightedQuickUnionUF(n);
        connections = new Connection[n];
        earliestTimes = new int[n];
        for (int i = 0; i < earliestTimes.length; i++) {
            earliestTimes[i] = -1;
        }
    }

    public void connect(int p, int q, int timestamp) {
        int rp = uf.find(p);
        int rq = uf.find(q);

        if (rp != rq) {
            uf.union(p, q);

            int root = uf.find(p);
            if (earliestTimes[root] == -1 || timestamp < earliestTimes[root]) {
                earliestTimes[root] = timestamp;
            }
        }

        connections[p] = new Connection(p, q, timestamp);

    }

    public int earliestTimeAllMembersAreConnected() {
        int earliestTime = Integer.MAX_VALUE;
        for (int time : earliestTimes) {
            if (time != -1 && time < earliestTime) {
                earliestTime = time;
            }
        }
        return earliestTime;
    }


    public static void main(String[] args) {
   
    }

}

class Connection {
    private int p;
    private int q;
    private int timestamp;

    public Connection(int p, int q, int timestamp) {
        this.p = p;
        this.q = q;
        this.timestamp = timestamp;
    }
}
