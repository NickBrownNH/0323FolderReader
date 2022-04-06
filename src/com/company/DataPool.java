package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Maintains a pool of data read from files in a folder
 * @author CPR
 */
public class DataPool {
    int fileCount = 0;
    //for PuzzlePool, add instance data which is an array of PicrossPuzzle objects

    /**
     * Loads all the files in the given path
     *
     * @param path the path that contains files to be read
     */
    public DataPool (Path path)
    {

        rr(path);
    }

    public void rr (Path path) {
        File[] files;
        File aFile;


        int[][] array2D;

        //dump all the file contents of the path into the local File array
        //all files and folders in the Data folder are collected
        aFile = new File(path.toString());
        files = aFile.listFiles();

        //iterate over each file in files
        for (File file : files) {
            //check to make sure file name ends with .txt, skips files like desktop.ini
            if(file.isFile()) {
                String fileName = file.toString();
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex > 0) { //filename has an extension
                    if (fileName.substring(dotIndex + 1).equals("txt")) {
                        System.out.println("File #: " + fileCount + "\t" + file);
                        array2D = readFile(file);
                        fileCount++;
                    }
                }
            } else {
                rr(file.toPath());
            }
        }
    }

    /**
     * Reads one file and store the contents into a 3x3 int array
     * File content is expected to be integers
     * @param file the file to be read
     * @return the 3x3 int array read from the file
     */
    private int[][] readFile(File file)
    {
        int[][] data = new int[3][3];

        try {
            Scanner readFrom = new Scanner(file);

            //read the 9 numbers from the file and store them into the 2D int array, data
            for (int i=0; i<3; i++)
                for (int j=0; j<3; j++)
                    data[i][j] = readFrom.nextInt();
            //data array is now filled, this may be used to instantiate a PicrossPuzzle object, but change to 5x5

            readFrom.close();
        }
        catch (IOException ex) {
            System.out.println(ex);
        }
        finally {
            //print contents of array to System.out to verify that data was read
            for (int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++)
                    System.out.print(data[i][j] + " ");
                System.out.println();
            }
            return data;
        }
    }
}
