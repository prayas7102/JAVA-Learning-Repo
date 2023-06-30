package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SynchronizedMethods {
    public static void main(String args[]) {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        process();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }

    private static Random random = new Random();
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();

    public static void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list1.add(random.nextInt(100));
    }

    public static void stageTwo() {

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list2.add(random.nextInt(100));
    }
}
