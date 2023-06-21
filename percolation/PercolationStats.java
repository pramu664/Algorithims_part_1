/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] thresholds;
    private int trials;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException(
                    "Invalid arguments: n and trials must be greater than 0.");
        }
        thresholds = new double[trials];
        this.trials = trials;

        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates()) {
                int row = (int) StdRandom.uniformDouble(0, n);
                int col = (int) StdRandom.uniformDouble(0, n);
                perc.open(row + 1, col + 1);
            }
            thresholds[i] = (double) perc.numberOfOpenSites() / (n * n);
        }

    }

    public double mean() {
        return StdStats.mean(thresholds);
    }

    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    public double confidenceLo() {
        double mean = mean();
        double stddev = stddev();
        return mean - 1.96 * stddev / Math.sqrt(trials);
    }

    public double confidenceHi() {
        double mean = mean();
        double stddev = stddev();
        return mean + 1.96 * stddev / Math.sqrt(trials);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, trials);

        System.out.println("Mean: " + stats.mean());
        System.out.println("Standard Deviation: " + stats.stddev());
        System.out.println(
                "95% Confidence Interval: [" + stats.confidenceLo() + ", " + stats.confidenceHi()
                        + "]");

    }
}
