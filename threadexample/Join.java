package threadexample;

//In this example, the main thread creates and starts 
//a new MyThread instance, and then waits for 
//the thread to complete using the join() method. 
//Once the thread has completed its execution, the 
//main thread continues execution and prints a message 
//to the console.
public class Join {
	  public static void main(String[] args) {
	    // create and start a new thread
	    Thread thread = new MyThread();
	    thread.start();

	    // wait for the thread to complete
	    try {
	      thread.join();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }

	    // continue execution of the main thread
	    System.out.println(" User Thread has completed, continuing execution of the main thread");
	  }
	}

 class MyThread extends Thread {
	  public void run() {
	    // code to be executed by the thread goes here
	    System.out.println("User Thread running");
	    try {
	      Thread.sleep(1000); // sleep for 1 second
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    System.out.println("User Thread completed");
	  }
	}
