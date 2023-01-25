package threadexample1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadExample1 {




    public static void main(String[] args) {
        // Multithreaded example
        MultithreadedWorker multithreadedWorker = new MultithreadedWorker();
        multithreadedWorker.start();

        // Parallel programming example
        Executor executor = Executors.newFixedThreadPool(2); // Create a thread pool with 2 threads
        ParallelWorker parallelWorker1 = new ParallelWorker();
        ParallelWorker parallelWorker2 = new ParallelWorker();
        executor.execute(parallelWorker1); // Start the first worker
        executor.execute(parallelWorker2); // Start the second worker
        ((ExecutorService) executor).shutdown(); // Shut down the thread pool
    }

    public static class MultithreadedWorker extends Thread {

        @Override
        public void run() {
            // Perform work on a single CPU or CPU core
        }
    }

    public static class ParallelWorker implements Runnable {

        @Override
        public void run() {
            // Perform work on a separate CPU or CPU core
        }
    }
}
