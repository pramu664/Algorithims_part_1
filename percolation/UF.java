/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class UF {
    // Instance variable
    int[][] id;

    // Constructor
    public UF(int N) {
        // Initilization
        id = new int[N][N];
        int idCounter = 0;
        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < id.length; j++) {
                id[i][j] = idCounter;
                idCounter += 1;
            }
        }
    }

    public boolean connected(int row1, int col1, int row2, int col2) {
        if (id[row1][col1] == id[row2][col2]) {
            return true;
        }
        else {
            return false;
        }
    }

    public void union(int row1, int col1, int row2, int col2) {
        int pid = id[row1][col1]; // get p holding value
        int qid = id[row2][col2]; // get q holding value

        for (int i = 0; i < id.length; i++) {
            for (int j = 0; j < id.length; j++) {
                // if ij holding value is equal to p holding value
                if (id[i][j] == pid) {
                    id[i][j] = qid; // then change ij holding value to q holding value
                }
            }
        }
    }


    public static void main(String[] args) {
        // Test client

        UF uf = new UF(3);
        uf.union(0, 0, 0, 1);
        uf.union(0, 1, 1, 1);
        // uf.union(8, 9);
        // uf.union(4, 5);
        // uf.union(7, 8);
        //
        // boolean result;
        // result = uf.connected(3, 4);
        // // -> true
        // result = uf.connected(6, 7);
        // // -> false
    }
}
