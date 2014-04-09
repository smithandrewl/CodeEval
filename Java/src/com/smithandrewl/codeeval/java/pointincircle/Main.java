package com.smithandrewl.codeeval.java.pointincircle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String regex =
            "Center: \\(([-.\\d]*), ([-.\\d]*)\\); Radius: ([-.\\d]*); Point: \\(([-.\\d]*), ([-.\\d]*)\\)";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));

            while(scanner.hasNextLine()) {
                System.out.println(processLine(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }

       public static String processLine(String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        matcher.find();

        float x1     = Float.parseFloat(matcher.group(1));
        float y1     = Float.parseFloat(matcher.group(2));
        float radius = Float.parseFloat(matcher.group(3));
        float x2     = Float.parseFloat(matcher.group(4));
        float y2     = Float.parseFloat(matcher.group(5));

        return String.valueOf(isPointInCircle(x1, y1, x2, y2, radius));
    }

    public static boolean isPointInCircle(float x1, float y1, float x2, float y2, float radius) {
        float xDiff = x2 - x1;
        float yDiff = y2 - y1;

        float distance = (float) Math.sqrt((xDiff * xDiff) + (yDiff * yDiff));

        return distance < radius;
    }
}
