package com.smithandrewl.codeeval.java.fibonacciseries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                int n = Integer.parseInt(scanner.nextLine());
                System.out.println(fastFib(n));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
    public static int fastFib(int n) {
        int result;

        switch (n) {
            case 0:
                result = 0;
                break;
            case 1:
                result = 1;
                break;
            case 2:
                result = 1;
                break;
            default:
                int m = n / 2;

                if(n % 2 == 0) {

                    int first = fastFib(m + 1);
                    int second = fastFib(m - 1);
                    result = (first * first) - (second * second);
                } else {

                    int first = fastFib(m + 1);
                    int second = fastFib(m);
                    result = (first * first) + (second * second);
                }
        }

        return result;
    }
}
