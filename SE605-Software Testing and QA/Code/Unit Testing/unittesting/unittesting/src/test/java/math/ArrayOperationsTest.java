package math;

import io.FileIO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayOperationsTest {
    private FileIO fileIO;
    private MyMath myMath;
    private ArrayOperations arrayOperations;

    @Before
    public void setUp(){
        fileIO = new FileIO();
        myMath = new MyMath();
        arrayOperations = new ArrayOperations();
    }

    private String getFilePath(String fileName) {
        String filePath = getClass().getClassLoader().getResource(fileName) != null
                ? getClass().getClassLoader().getResource(fileName).getPath()
                : null;
        if (filePath == null) throw new IllegalArgumentException("File not found: " + fileName);
        return filePath.replace("%20", " ");
    }

    @Test
    public void findPrimesinFileForPositiveNumbersGreaterThanOne(){
        String filePath = getFilePath("positive-numbers.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        int[] valid = {2,104729,23,3,7,1000000007};
        assertArrayEquals(valid,res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForMixedNumbers(){
        String filePath = getFilePath("mixed.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForNegativeNumbers(){
        String filePath = getFilePath("negative-numbers.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForDecimalNumbers(){
        String filePath = getFilePath("decimal.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForNonNegativeNumbersBelowTwo(){
        String filePath = getFilePath("onetwo.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForEmptyFile(){
        String filePath = getFilePath("empty.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findPrimesInFileForNonExistentFile(){
        String filePath = getFilePath("nonexistentfile.txt");
        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
    }

}