/*
 * Compilation: javac RandomWord.java
 *  Execution: java RandomWord
 *
 *  Reads a sequence of words from standard input and prints one of those words uniformly at random
 *
 *  % java RandomWord < animals8.txt
 *  bear
 */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = StdIn.readString();
        int i = 2;
        while (!StdIn.isEmpty()) {
            String challenger = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / (double) i)) {
                champion = challenger;
            }
            i++;
        }
        StdOut.println(champion);
    }
}
