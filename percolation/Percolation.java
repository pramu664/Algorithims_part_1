/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.Vector;

public class Percolation {
    public Percolation(int n) {
        // Create 2D array.
        int[][] mySystem = new int[n][n];

        // Block all the sites internally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mySystem[i][j] = 0;
            }
        }

    }

    public void open(int row, int col) {
        // TODO
        // Unifomaly pick random cell between zero and size of 2D array.
        int counter = 1;
        Vector cell;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // ??
                counter++;
            }
        }

        // Index into the 2D array and set 1 as that variable value.
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
