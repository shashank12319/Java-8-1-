package objectbasedsynchronization;

class MyClass {
    // Declare the objects that will be used for synchronization
    final Object lock1 = new Object();
    final Object lock2 = new Object();

    public void methodA(Object lock) {
        // Acquire the lock on the object for a short period of time
        synchronized (lock) {
            System.out.println("Entering methodA");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            System.out.println("Exiting methodA");
        }
    }

    public void methodB(Object lock) {
        // Acquire the lock on the object for a short period of time
        synchronized (lock) {
            System.out.println("Entering methodB");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Handle the exception
            }
            System.out.println("Exiting methodB");
        }
    }
}

public class ObjectBasedSynchronization {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        Thread t1 = new Thread(() -> obj.methodA(obj.lock1));
        Thread t2 = new Thread(() -> obj.methodB(obj.lock1));

        t1.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // Handle the exception
        }
    }
}


