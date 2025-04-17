package math;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ArithmeticOperationsTest {

    @Test(expected = ArithmeticException.class)
    public void Test_Divide_Divide_By_Zero(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.divide(10.0,0);
    }

    @Test
    public void Test_Divide_Normal(){
        Double expected = 2.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(10.0,5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void Test_Divide_Negative_Denominator(){
        Double expected = -3.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(15.0,-5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void Test_Divide_Negative_Numerator(){
        Double expected = -5.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(-25.0,5.0);
        assertEquals(expected,val,1e-5);
    }

    @org.junit.Test
    public void Test_Divide_Negative_Both(){
        Double expected = 5.0;
        ArithmeticOperations ao = new ArithmeticOperations();
        Double val = ao.divide(-25.0,-5.0);
        assertEquals(expected,val,1e-5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Negative_Number_First(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(-1, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Negative_Number_Second(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(1, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Negative_Number_Both(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(-1, -4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Zero_First_Number(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(0, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Zero_Second_Number(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(1, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Test_Multiply_Fit_In_Integer_Var(){
        ArithmeticOperations ao = new ArithmeticOperations();
        ao.multiply(100000000, 1000000000);
    }

    @org.junit.Test
    public void Test_Multiply_Normal(){
        ArithmeticOperations ao = new ArithmeticOperations();
        int expected = 1400;
        int val = ao.multiply(100, 14);
        assertEquals(expected,val);
    }

}