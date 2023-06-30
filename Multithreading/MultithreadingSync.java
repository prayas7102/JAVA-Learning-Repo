package Multithreading;

class MultithreadingSync {

  public static void main(String[] args) throws Exception {
    Counter c = new Counter();
    Thread t1 = new Thread(
      new Runnable() {
        public void run() {
          for (int index = 0; index < 1000; index++) {
            c.increment();
          }
        }
      }
    );
    Thread t2 = new Thread(
      new Runnable() {
        public void run() {
          for (int index = 0; index < 1000; index++) {
            c.increment();
          }
        }
      }
    );
    // Start both threads
        t1.start();
        t2.start();
  
        // t1 finishes before t2
        t1.join();
        t2.join();
    System.out.println(c.count);
  }
}

class Counter {

  int count;
  // implements a mutex which avoids concurrency of threads
  public synchronized void increment() {
    count++;
  }
}
