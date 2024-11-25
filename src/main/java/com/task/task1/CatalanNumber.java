package com.task.task1;

import java.util.stream.IntStream;

/**
 * The problem uses Catalan numbers to solve task.
 * Catalan numbers count the N situation of valid sequences
 */
public class CatalanNumber {

    /**
     * This method calculates the N Catalan number using recursion
     *
     * @param n - index of number
     * @return - result of the operation
     */
    public int getCatalan(int n) {
        if (n == 0) {
            return 1;
        }

        // recursiveky compute the N number
        return IntStream.range(0, n)
                .map(i -> getCatalan(i) * getCatalan(n - 1 - i))
                .sum();
    }
}
