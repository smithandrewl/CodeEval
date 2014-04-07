package com.smithandrewl.codeeval.java.sumofprimes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumOfPrimes(1000));
    }

    public static int sumOfPrimes(int n) {
        int count = 0;
        int curr  = 2;
        int sum   = 0;

        while(count < n) {
            if(isPrime(curr)) {
                sum += curr;
                count++;
            }

            curr++;
        }

        return sum;
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
