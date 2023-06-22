package Multithreading;

class Multithreading extends Thread implements Runnable {

  public void run() {
    System.out.println("Running by runnable interface");
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
    hi.join();    // until the hi thread dies and joins with the main thread, below threads wont be called.
    System.out.println(hi.isAlive());

    Thread t3 = new Thread(() -> {
      System.out.println("Running by arrow func");
    });
    t3.start();

    System.out.println("completed");

  }
}

class Hello extends Thread {

  public void run() {
    for (int i = 0; i < 2; i++) {
      System.out.println("Hello");
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
      System.out.println("Hi");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
// git config --global user.email ""
