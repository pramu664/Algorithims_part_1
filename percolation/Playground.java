/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

public class Playground {

    public Playground(int n) {

    }

    public static int getRandomIndex(int size) {
        int index = 0;
        double p = 0;
        for (int i = 0; i < size; i++) {
            p = 1.0 / (i + 1);
            if (StdRandom.bernoulli(1.0 / (i + 1))) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // Test Client
        getRandomIndex(3);

    }
}
