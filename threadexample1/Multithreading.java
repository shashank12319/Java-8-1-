package threadexample1;


public class Multithreading {
	  public static void main(String[] args) {
	    // create and start two threads
	    Thread thread1 = new MyThread("Thread 1");
	    Thread thread2 = new MyThread("Thread 2");
	    thread1.start();
	    thread2.start();
	  }
	}

	 class MyThread extends Thread {
	  private String name;

	  public MyThread(String name) {
	    this.name = name;
	  }

	  public void run() {
	    for (int i = 0; i < 10; i++) {
	      System.out.println(name + ": " + i);
	      try {
	        Thread.sleep(1000); // sleep for 1 second
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	  }
	}
