/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */


import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private WeightedQuickUnionUF uf;
    private int openSites;
    private int size;
    private int top;
    private int bottom;

    public Percolation(int n) {
        grid = new int[n][n];
        uf = new WeightedQuickUnionUF((n) * (n) + 2);
        size = n;
        top = 0;
        bottom = (n) * (n) + 1;
    }

    public void open(int row, int col) {
        row--;
        col--;

        // Check if the indices are valid
        if (!validSite(row, col)) return;

        if (grid[row][col] == 1) return;

        // Open site
        grid[row][col] = 1;
        openSites++;

        int currentSiteIndex = getIndex(row, col);

        // connect to virtual top
        if (row == 0) {
            uf.union(currentSiteIndex, top);
        }
        // connect to virtual bottom
        if (row == size - 1) {
            uf.union(currentSiteIndex, bottom);
        }

        // connect to adjecent neighbours if they are open
        connectAdjacentNeighbours(row, col, currentSiteIndex);
    }

    public boolean isOpen(int row, int col) {
        // return grid[row][col] == 0 ? true : false;
        return grid[row - 1][col - 1] == 1;
    }

    public boolean isFull(int row, int col) {
        int siteIndex = getIndex(row - 1, col - 1);
        return grid[row - 1][col - 1] != 0 && uf.find(siteIndex) == uf.find(top);
    }

    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    // Helper function
    private void connectAdjacentNeighbours(int row, int col, int currentSiteIndex) {
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } }; // up, down, left , right

        for (int i = 0; i < directions.length; i++) {
            int newRow = row + directions[i][0];
            int newCol = col + directions[i][1];

            if (validSite(newRow, newCol) && grid[newRow][newCol] == 1) {
                int adjecentSiteIndex = getIndex(newRow, newCol);
                uf.union(currentSiteIndex, adjecentSiteIndex);
            }

        }
    }

    private int getIndex(int row, int col) {
        return row * size + col;
    }

    private boolean validSite(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public static void main(String[] args) {
    }

}


