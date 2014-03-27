package com.smithandrewl.codeeval.java.nmodm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while (scanner.hasNextLine()) {
                processLine(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

    private static void processLine(String line) {
        String[] parts = line.split(",");

        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);

        System.out.println(nmodm(n, m));
    }

    public static int nmodm(int n, int m) {
        int times = n / m;

        return n - (times * m);
    }
}
