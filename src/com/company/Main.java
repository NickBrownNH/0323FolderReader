package com.company;

import java.nio.file.Paths;

public class Main {

    /**
     * Driver/tester for the DataPool class
     * @param args unused arguments
     */
    public static void main(String[] args) {
        DataPool pool = new DataPool(Paths.get(".\\Data"));
    }
}
