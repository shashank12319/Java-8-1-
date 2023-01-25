package main;


class MyClass {
	  private final Object lockA = new Object();
	  private final Object lockB = new Object();

	  public void methodA() {
	    synchronized(lockA) {
	      // code for method A
	    	System.out.println("Method A");
	    }
	  }

	  public void methodB() {
	    synchronized(lockB) {
	      // code for method B
	    	System.out.println("Method B");
	    }
	  }
	}
class MyThread extends Thread {
	  private MyClass obj;
	  private String method;

	  public MyThread(MyClass obj, String method) {
	    this.obj = obj;
	    this.method = method;
	  }

	  @Override
	  public void run() {
	    if (method.equals("A")) {
	      obj.methodA();
	    } else if (method.equals("B")) {
	      obj.methodB();
	    }
	  }
	}

	public class Main {
	  public static void main(String[] args) {
	    MyClass obj = new MyClass();

	    Thread thread1 = new MyThread(obj, "A");
	    Thread thread2 = new MyThread(obj, "B");

	    thread1.start();
	    thread2.start();
	  }
	}
	//In this example, thread1 will access method A,
	//which will acquire the lock for lockA and 
	//execute the code for method A. At the same time, 
	//thread2 will access method B, which will acquire the 
	//lock for lockB and execute the code for method B. 
	//This allows the two threads to access the two methods
	//concurrently, without the need for unnecessary locking.