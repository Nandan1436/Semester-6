package math;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMathTest {
    @Test
    public void factorialForFive(){
        MyMath m = new MyMath();
        assertEquals(120,m.factorial(5));
    }

    @Test
    public void factorialForTwelve(){
        MyMath m = new MyMath();
        assertEquals(479001600,m.factorial(12));
    }

    @Test
    public void factorialForZero(){
        MyMath m = new MyMath();
        assertEquals(1,m.factorial(0));
    }

    @Test
    public void factorialForOne(){
        MyMath m = new MyMath();
        assertEquals(1,m.factorial(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialForNegativeThree(){
        MyMath m = new MyMath();
        m.factorial(-3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialForNegativeOne(){
        MyMath m = new MyMath();
        m.factorial(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void factorialForThirteen(){
        MyMath m = new MyMath();
        m.factorial(13);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPrimeForOne(){
        MyMath m = new MyMath();
        m.isPrime(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPrimeForZero(){
        MyMath m = new MyMath();
        m.isPrime(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isPrimeForNegativeTwentyOne(){
        MyMath m = new MyMath();
        m.isPrime(-21);
    }

    @Test
    public void isPrimeForTwo(){
        MyMath m = new MyMath();
        assertTrue(m.isPrime(2));
    }

    @Test
    public void isPrimeForNinetyOne(){
        MyMath m = new MyMath();
        assertFalse(m.isPrime(91));
    }

    @Test
    public void isPrimeForLargeNumber(){
        MyMath m = new MyMath();
        assertTrue(m.isPrime(1000000007));
    }

}