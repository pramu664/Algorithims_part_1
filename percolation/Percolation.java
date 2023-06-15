/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

public class Percolation {
    private int[][] precolationSystem;

    public Percolation(int n) {

        precolationSystem = new int[n + 1][n + 1];

        // Block all the sites internally
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                precolationSystem[i][j] = 0;
            }
        }

    }

    public static int getRandomIndex(int size) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (StdRandom.bernoulli(1.0 / (i + 1))) {
                index = i;
            }
        }
        return index;
    }

    public void open(int row, int col) {

        //  pick random site and open it
        precolationSystem[row][col] = 1;

    }

    public boolean isOpen(int row, int col) {
        // TODO
        if (precolationSystem[row][col] == 1) {
            return true;
        }
        else {
            return false;
        }
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
        Percolation mySys = new Percolation(1);

        mySys.open(1, 1);


    }
}
