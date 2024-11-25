package com.task.task3;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        NumericUtil nu = new NumericUtil();
        BigInteger factorial = nu.factorial(100);
        long sum = nu.sumOfDigit(factorial);
        System.out.println(sum);
    }
}
