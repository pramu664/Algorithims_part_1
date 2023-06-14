/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Percolation {
    public Percolation(int n) {
        // Create 2D array.
        int[][] mySystem = new int[n][n];

        // Block all the sites internally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mySystem[i][j] = i + j;
            }
        }

    }

    public void open(int row, int col) {
        // TODO
    }

    public boolean isOpen(int row, int col) {
        // TODO
        return false;
    }

    public boolean isFull(int row, int col) {
        // TODO
        return false;
    }

    public int numberOfOpenSites() {
        // TODO
        return 0;
    }

    public boolean percolates() {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Percolation mySys = new Percolation(3);
    }
}
