package threadexample;
//In this example, Thread1 will lock methodA and methodB
//when it executes, while Thread2 can execute methodB 
//concurrently with Thread1.

class MyClass {
    // Method A
    public synchronized void methodA() {
        // code for method A goes here
    	System.out.println("Method-A");
    }

    // Method B
    public void methodB() {
        // code for method B goes here
    	System.out.println("Method-B");
    }
}

class Thread1 extends Thread {
    private MyClass myClass;

    public Thread1(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        // Lock method A
        synchronized (myClass) {
            myClass.methodA();
        }
    }
}

class Thread2 extends Thread {
    private MyClass myClass;

    public Thread2(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        // Method B does not need to be locked, as it does not conflict with method A
        myClass.methodB();
    }
}

public class ThreadExample1 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Thread1 thread1 = new Thread1(myClass);
        Thread2 thread2 = new Thread2(myClass);

        thread1.start();
        thread2.start();
    }
}

