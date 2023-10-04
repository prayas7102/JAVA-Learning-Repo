public class OracleMultithreading {
    public static void main(String args[])
            throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    // Your thread's work
                    System.out.println("Working...");
                    // Check the interrupt flag
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread interrupted. Exiting...");
                        throw new InterruptedException();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });

        // A new thread is created and started using thread.start().
        // The new thread executes the infinite loop, performing some work in each
        // iteration.
        // Meanwhile, in the main thread, there's a delay of 2 seconds using
        // Thread.sleep(2000).
        // After the 2-second delay, the main thread calls thread.interrupt() to
        // interrupt the running thread.

        thread.start(); // Start the thread

        // Interrupt the thread after a delay
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the thread
        thread.interrupt();

        // In the given scenario where you have a main thread and a new thread running
        // concurrently, both threads are operating on the same single processor. The
        // concurrency is achieved through time slicing or time-sharing, where the
        // processor rapidly switches between executing instructions for each thread,
        // giving the illusion of parallel execution.
    }
}