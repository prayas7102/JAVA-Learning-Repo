package Multithreading;

class Multithreading {
  public static void main(String[] args) {
    Run run = new Run();
    run.start();
  }
}

class Run extends Thread {

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(getState());
    }
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
