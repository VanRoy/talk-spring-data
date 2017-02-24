package com.github.vanroy.springdata.specifications.output;

import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;

/**
 * Utility class to write data to console.
 * @author Julien Roy
 */
public class ConsoleOutput {

    public static void write(Object object) {
        writeBanner();
        System.out.println(object);
        writeBanner();
    }

    public static void write(Iterable<?> objects) {
        writeBanner();
        for (Object object : objects) {
            System.out.println(object);
        }
        writeBanner();
    }

    public static void writeBanner() {
        System.out.println();
        System.out.println(AnsiOutput.toString(AnsiColor.GREEN , "-------------------------------" ));
//        System.out.println(AnsiOutput.toString(AnsiColor.GREEN , "| *************************** |" ));
//        System.out.println(AnsiOutput.toString(AnsiColor.GREEN , "-------------------------------" ));
        System.out.println();
    }
}
