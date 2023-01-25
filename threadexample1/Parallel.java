package threadexample1;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Parallel {
  public static void main(String[] args) {
    // create a thread pool with 4 threads
    Executor executor = Executors.newFixedThreadPool(4);

    // create and start three tasks
    MyTask task1 = new MyTask("Task 1");
    MyTask task2 = new MyTask("Task 2");
    MyTask task3 = new MyTask("Task 3");
    executor.execute(task1);
    executor.execute(task2);
    executor.execute(task3);
  }
}

 class MyTask implements Runnable {
  private String name;

  public MyTask(String name) {
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
