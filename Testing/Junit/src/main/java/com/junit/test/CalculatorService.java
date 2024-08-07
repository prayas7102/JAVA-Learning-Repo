package com.junit.test;

/**
 * Hello world!
 *
 */
public class CalculatorService
{
    public static int addTwoNum( int a, int b )
    {
        return a+b;
    }
    public static int addNumArray( int ...num )
    {
        int s=0;
        for (int n:num){
            s+=n;
        }
        return s;
    }
}
