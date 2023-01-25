package threadexample;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadExample{

    private final ReentrantLock lockA = new ReentrantLock();

    @SuppressWarnings("unused")
	private void methodA() {
        lockA.lock(); // Acquire the lock for methodA
        try {
            Thread.currentThread();
			Thread.sleep(100000);
        } catch (InterruptedException e) {

        }
        System.out.println("I am in method A");
        lockA.unlock(); // Release the lock
    }

    @SuppressWarnings("unused")
    
	private void methodB() {
    	lockA.lock();
        System.out.println("I am in method B");
        lockA.unlock();
    }
    public static void main(String[] args) {
    	ThreadExample reintrantobject=new ThreadExample();
		
		Thread thread1 = new Thread(() -> {
			reintrantobject.methodA();
		});
		Thread thread2=new Thread(()->  {
			reintrantobject.methodB();
		});
		thread1.start();
		thread2.start();
	}
}