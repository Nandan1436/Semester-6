package io;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileIOTest {
    private FileIO fileIO;

    @Before
    public void setUp(){
        fileIO = new FileIO();
    }

    private String getFilePath(String fileName) {
        String filePath = getClass().getClassLoader().getResource(fileName) != null
                ? getClass().getClassLoader().getResource(fileName).getPath()
                : null;
        if (filePath == null) throw new IllegalArgumentException("File not found: " + fileName);
        return filePath.replace("%20", " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFileForNonExistentFile(){
        String filePath = getFilePath("nonexistentfile.txt");
        if(filePath==null) throw new IllegalArgumentException("");
        int[] res = fileIO.readFile(filePath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void readFileForEmptyFile(){
        String filePath = getFilePath("empty.txt");
        int[] res = fileIO.readFile(filePath);
    }

    @Test(expected = NumberFormatException.class)
    public void readFileForInvalid(){
        String filePath = getFilePath("invalid.txt");
        int[] res = fileIO.readFile(filePath);
    }

    @Test(expected = NumberFormatException.class)
    public void readFileForDecimalNumbers(){
        String filePath = getFilePath("invalid.txt");
        int[] res = fileIO.readFile(filePath);
    }

    @Test
    public void readFileForMixedNumbers(){
        String filePath = getFilePath("mixed.txt");
        int[] res = fileIO.readFile(filePath);
        int[] valid = {435, 0, -234, 0, 0, 2342, 99, 14, 11, -943, -33, 7};
        assertArrayEquals(valid,res);
    }

    @Test
    public void readFileForNegativeNumbers(){
        String filePath = getFilePath("negative-numbers.txt");
        int[] res = fileIO.readFile(filePath);
        int[] valid = {-545, -434, -6, -4, -323};
        assertArrayEquals(valid,res);
    }

    @Test
    public void readFileForPositiveNumbers(){
        String filePath = getFilePath("positive-numbers.txt");
        int[] res = fileIO.readFile(filePath);
        int[] valid = {4,2,99,23423,23,3,91,7,1000000007};
        assertArrayEquals(valid,res);
    }

}