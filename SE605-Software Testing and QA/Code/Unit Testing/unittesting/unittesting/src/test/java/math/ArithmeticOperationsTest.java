package math;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArithmeticOperationsTest {

    @Test(expected = ArithmeticException.class)
    public void divideWithZero(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.divide(10.0,0);
    }

    @Test
    public void divideWithPositiveNumbers(){
        Double expected = 2.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(10.0,5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void divideWithNegativeDenominator(){
        Double expected = -3.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(15.0,-5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void divideWithNegativeNumerator(){
        Double expected = -5.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(-25.0,5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void divideWithNegativeNumbers(){
        Double expected = 5.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(-25.0,-5.0);
        assertEquals(expected,val,1e-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithFirstNumberNegative(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(-1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithSecondNumberNegative(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(1, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithBothNumbersNegative(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(-1, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithFirstNumberZero(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithSecondNumberZero(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithVeryLargeNumbers(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(100000000, 1000000000);
    }

    @org.junit.Test
    public void multiplyWithPositiveNumbers(){
        ArithmeticOperations ao = new ArithmeticOperations();
        int expected = 1400;
        int val = ao.multiply(100, 14);
        assertEquals(expected,val);
    }

}