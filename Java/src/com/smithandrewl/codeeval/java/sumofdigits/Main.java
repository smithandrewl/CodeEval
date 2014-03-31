package com.smithandrewl.codeeval.java.sumofdigits;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                int    num  = Integer.parseInt(line);

                System.out.println(sumOfDigits(num));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public static int sumOfDigits(int num) {
        int curr = num;
        int sum  = 0;

        while(curr > 0) {
            sum  += curr % 10;
            curr /= 10;
        }

        return sum;
    }
}
