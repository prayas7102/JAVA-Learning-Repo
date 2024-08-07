package com.junit.test.services;

import com.junit.test.CalculatorService;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    @Test
    public void addTwoNumbers(){
        System.out.println("Test: addTwoNumbers");
        int actualResult = CalculatorService.addTwoNum(12,12);
        int expectedResult = 24;
        Assertions.assertEquals(expectedResult,actualResult,"assertion failed");
    }
    @Test
    public void compareArr(){
        System.out.println("Test: compareArr");
        int[] expectedResult = {1, 2, 3, 4, 5};
        int[] actualResult = {1, 2, 3, 4, 5};
        // assertSame & assertEquals does'nt work for array
        // with same values but works for string with same value
        Assertions.assertArrayEquals(expectedResult,actualResult,"assertion failed");
    }
    @Test
    public void compareStr(){
        System.out.println("Test: compareStr");
        String expectedResult = "rahul";
        String actualResult = "rahul";
        // assertSame and assertEquals both work
        Assertions.assertSame(expectedResult,actualResult,"assertion failed");
        /**
         Above assertion doesn't works if strings are declared
        in following way:
        String expectedResult = new String("rahul");
        String actualResult = new String("rahul");
         */
    }
    @Test
    public void compareIterables(){
        System.out.println("Test: compareIterables");
        List<Integer> expectedResult = Arrays.asList(1,2,3,4);
        List<Integer> actualResult = Arrays.asList(1,2,3,4);
        Assertions.assertIterableEquals(expectedResult,actualResult,"assertion failed");
    }
    @Test
    public void compareException(){
        System.out.println("Test: compareException");
        Assertions.assertThrows(RuntimeException.class,()->{throw new RuntimeException("this is testing exception");},"assertion failed");
    }
    @Test
    @Disabled
    public void addNumArray(){
        System.out.println("Test: addNumArray");
        int actualResult = CalculatorService.addNumArray(12,12,9,8,6);
        int expectedResult = 47;
        Assertions.assertEquals(expectedResult,actualResult,"assertion failed");
    }
    @BeforeAll
    public static void beforeAll(){
        System.out.println("before all test");
    }
    @AfterEach
    public void afterEachTest(){
        System.out.println("after each test");
    }
    @BeforeEach
    public void beforeEachTest(){
        System.out.println("before each test");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("after all test");
    }
}
