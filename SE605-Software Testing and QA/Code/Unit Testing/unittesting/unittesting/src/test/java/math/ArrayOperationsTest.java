package math;

import io.FileIO;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ArrayOperationsTest {
    private FileIO fileIO;
    private MyMath myMath;
    private ArrayOperations arrayOperations;

    @Before
    public void setUp(){
        fileIO = mock(FileIO.class);
        myMath = mock(MyMath.class);
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
    public void findPrimesInFileForPositiveNumbersGreaterThanOne(){
        String filePath = getFilePath("positive-numbers.txt");

        when(fileIO.readFile(filePath)).thenReturn(new int[]{4,2,99,104729,23,3,91,7,1000000007});
        when(myMath.isPrime(4)).thenReturn(false);
        when(myMath.isPrime(2)).thenReturn(true);
        when(myMath.isPrime(99)).thenReturn(false);
        when(myMath.isPrime(104729)).thenReturn(true);
        when(myMath.isPrime(23)).thenReturn(true);
        when(myMath.isPrime(3)).thenReturn(true);
        when(myMath.isPrime(91)).thenReturn(false);
        when(myMath.isPrime(7)).thenReturn(true);
        when(myMath.isPrime(1000000007)).thenReturn(true);

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        int[] valid = {2,104729,23,3,7,1000000007};
        assertArrayEquals(valid,res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, times(9)).isPrime(anyInt());
    }

    @Test
    public void findPrimesInFileForMixedNumbers(){
        String filePath = getFilePath("mixed.txt");
        when(fileIO.readFile(filePath)).thenReturn(new int[]{435, 0, -234, 0, 0, 2342, 99, 14, 11, -943, -33, 7});

        when(myMath.isPrime(435)).thenReturn(false);
        when(myMath.isPrime(0)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-234)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(2342)).thenReturn(false);
        when(myMath.isPrime(99)).thenReturn(false);
        when(myMath.isPrime(14)).thenReturn(false);
        when(myMath.isPrime(11)).thenReturn(true);
        when(myMath.isPrime(-943)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-33)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(7)).thenReturn(true);

        int[] res = arrayOperations.findPrimesInFile(fileIO, filePath, myMath);
        int[] valid = {11,7};
        assertArrayEquals(valid,res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, times(12)).isPrime(anyInt());
    }

    @Test
    public void findPrimesInFileForNegativeNumbers(){
        String filePath = getFilePath("negative-numbers.txt");
        when(fileIO.readFile(filePath)).thenReturn(new int[]{-545, -434, -6, -4, -323});

        when(myMath.isPrime(-545)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-434)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-6)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-4)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(-323)).thenThrow(new IllegalArgumentException());

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        int[] valid = {};
        assertArrayEquals(valid,res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, times(5)).isPrime(anyInt());
    }

    @Test
    public void findPrimesInFileForDecimalNumbers(){
        String filePath = getFilePath("decimal.txt");
        when(fileIO.readFile(filePath)).thenThrow(new NumberFormatException());

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        int[] valid = {};
        assertArrayEquals(valid,res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, never()).isPrime(anyInt()); // no interaction expected
    }

    @Test
    public void findPrimesInFileForNonNegativeNumbersBelowTwo(){
        String filePath = getFilePath("onetwo.txt");
        when(fileIO.readFile(filePath)).thenReturn(new int[]{0,1,1,0});

        when(myMath.isPrime(0)).thenThrow(new IllegalArgumentException());
        when(myMath.isPrime(1)).thenThrow(new IllegalArgumentException());

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        int[] valid = {};
        assertArrayEquals(valid,res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, times(4)).isPrime(anyInt()); // 0,1,1,0
    }

    @Test
    public void findPrimesInFileForEmptyFile(){
        String filePath = getFilePath("empty.txt");
        when(fileIO.readFile(filePath)).thenThrow(new IllegalArgumentException());

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        assertArrayEquals(new int[0], res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, never()).isPrime(anyInt());
    }

    @Test
    public void findPrimesInFileForNonExistentFile(){
        String filePath = getFilePath("nonexistentfile.txt");
        when(fileIO.readFile(filePath)).thenThrow(new IllegalArgumentException());

        int[] res = arrayOperations.findPrimesInFile(fileIO,filePath,myMath);
        assertArrayEquals(new int[0], res);

        verify(fileIO, times(1)).readFile(filePath);
        verify(myMath, never()).isPrime(anyInt());
    }


}