package Multithreading;

class Multithreading extends Thread implements Runnable {
  // get priority of given thread
  public void run() {
    System.out.println("Running by runnable interface "+ Thread.currentThread().getPriority());
  }

  public static void main(String[] args) throws Exception {

    Multithreading t1 = new Multithreading();
    Thread t2 = new Thread(t1);
    // this will call run() method
    t2.start();
    t1.start();

    Hello hello = new Hello();
    Hi hi = new Hi();
    hello.start();
    try {Thread.sleep(100);} catch (InterruptedException e) {}

    hi.start();
    System.out.println(hi.isAlive());
    hi.join(); // until the hi thread dies and joins with the main thread, below threads wont be called.
    System.out.println(hi.isAlive());

    Thread t3 = new Thread(() -> {
      System.out.println("Running by arrow func "+ Thread.currentThread().getPriority());
    });
    t3.start();

    System.out.println("Thread completed "+ Thread.currentThread().getPriority());

  }
}

class Hello extends Thread {
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println("Hello " + Thread.currentThread().getPriority());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Hi extends Thread {
  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println("Hi " + Thread.currentThread().getPriority());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// git config --global user.email ""
