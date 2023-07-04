package Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SynchronizedMethods {

    private static Random random = new Random();
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    private static List<Integer> list1 = new ArrayList<Integer>();
    private static List<Integer> list2 = new ArrayList<Integer>();
    public static void main(String args[]) {
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + list1.size());
        System.out.println("List2: " + list2.size());
    }

    public static void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public synchronized static void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list1.add(random.nextInt(100));
    }

    public synchronized static void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list2.add(random.nextInt(100));
    }
}
//        In general, using threads in a Java program can potentially
//        improve performance by allowing concurrent execution of
//        tasks. By utilizing multiple threads, a program can take
//        advantage of parallelism and execute multiple processes
//        simultaneously, potentially reducing overall execution time.

//    Without using threads:
//        Time taken:4103
//        List1:1000
//        List2:1000

//    With using threads:
//        Time taken: 3972
//        List1: 1995
//        List2: 1995

//    With using synchronized on stage1 & stage2 threads:
//        Time taken: 7981
//        List1: 2000
//        List2: 2000