package threadexample;
//In this example, the CyclicBarrier is initialized
//with a count of 2, which means that both the main thread 
//and the user thread need to call await() on the barrier 
//before the threads are allowed to continue execution.
//When the user thread calls await(), it will be blocked 
//until the main thread also calls await().
//When both threads have called await(), they will be released 
//and allowed to continue execution.
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadExample6 {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);

        Thread userThread = new Thread(() -> {
            // Do some work in the user thread
        	try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            System.out.println("User thread is doing some work...");
        });

        userThread.start();

        // Block the main thread until the user thread finishes
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        // Main thread continues execution after user thread finishes
        System.out.println("Main thread continuing execution...");
    }
}
