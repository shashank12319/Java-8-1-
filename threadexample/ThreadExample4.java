package threadexample;
//In this example, the main thread enters a synchronized
//block and waits for the user thread
//to finish execution by checking the value of the 
//userThreadFinished variable. 
//The user thread sets the variable to true and 
//calls the notify() method to wake up
//the main thread when it finishes execution. 
//The main thread then continues execution and prints a message.
public class ThreadExample4 {

    private static boolean userThreadFinished = false;

    public static void main(String[] args) {
        UserThread userThread = new UserThread();
        userThread.start();

        synchronized (userThread) {
            while (!userThreadFinished) {
                try {
                    userThread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Main thread continuing execution");
    }

    public static class UserThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000); // Sleep for 5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            userThreadFinished = true;
            synchronized (this) {
                notify();
            }

            System.out.println("User thread finished execution");
        }
    }
}
