package com.smithandrewl.codeeval.java.minimumcoins;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                int amount = Integer.parseInt(scanner.nextLine());
                System.out.println(minimumCoins(amount));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    public static int minimumCoins(int amount) {
        int coins = 0;
        int left  = amount;

        coins += left / 5;
        left  =  left % 5;

        coins += left / 3;
        left  =  left % 3;

        coins += left;

        return coins;
    }
}
