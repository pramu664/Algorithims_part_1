/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

// "ChampionWordPicker: Knuth Method Implementation"

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {

        // Set initial values to champ and i
        String champ = "";
        double i = 1;

        // Figure out the survived champ
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (StdRandom.bernoulli(1 / i)) {
                champ = word;
            }
            i++;
        }

        // Print the champ
        if (!champ.isEmpty()) {
            StdOut.println(champ);
        }

    }
}
