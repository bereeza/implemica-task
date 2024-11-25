package com.task.task3;

import java.math.BigInteger;

/**
 * Utility class that provides methods:
 * 1) factorial calculating. (The class uses BigInteger to have no limit in size of number)
 * 2) sum of digits in number
 */
public class NumericUtil {

    /**
     * Compute the factorial of a given number
     *
     * @param n - the number for which the factorial is to be calculated (n >= 0)
     * @return - N factorial result
     */
    public BigInteger factorial(int n) {
        if (n <= 2 && n >= 0) {
            return BigInteger.valueOf(n);
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            // multiply the current result by the current incrementation value (i)
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Compute the sum of digits of a given value
     *
     * @param n - our number that we need to calculate
     * @return - sum of digits in number
     */
    public long sumOfDigit(BigInteger n) {
        String num = n.toString();

        // convert each char to numeric value and sum them
        return num.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
