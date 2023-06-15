/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class UF {
    // Instance variable
    int[] id;

    // Constructor
    public UF(int N) {
        // Intitialize an empty array
        id = new int[N];

        // Initial state: Populate with numbers
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        if (id[p] == id[q]) {
            return true;
        }
        else {
            return false;
        }
    }

    public void union(int p, int q) {
        int pid = id[p]; // get p holding value
        int qid = id[q]; // get q holding value

        for (int i = 0; i < id.length; i++) {
            // if i holding value is equal to p holding value
            if (id[i] == pid) {
                id[i] = qid; // then change i holding value to q holding value
            }
        }
    }


    public static void main(String[] args) {
        // Test client
       
        UF uf = new UF(10);
        uf.union(3, 4);
        uf.union(1, 2);
        uf.union(8, 9);
        uf.union(4, 5);
        uf.union(7, 8);

        boolean result;
        result = uf.isConnected(3, 4);
        // -> true
        result = uf.isConnected(6, 7);
        // -> false
    }
}
