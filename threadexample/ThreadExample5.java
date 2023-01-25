package threadexample;

import java.util.concurrent.CountDownLatch;
//In this example, the main thread creates a CountDownLatch
//with a count of 1 and passes it to the user thread. 
//The user thread decrements the count when it finishes 
//execution. The main thread calls the await() method on the 
//latch, which causes it to wait until the count reaches 0
//before continuing.
public class ThreadExample5 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        UserThread userThread = new UserThread(latch);
        userThread.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread continuing execution");
    }

    public static class UserThread extends Thread {

        private CountDownLatch latch;

        public UserThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            latch.countDown();
            System.out.println("User thread finished execution");
        }
    }
}

