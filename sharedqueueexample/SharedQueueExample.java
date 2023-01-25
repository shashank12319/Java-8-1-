package sharedqueueexample;
//In this example, the generatorThread generates
//random numbers and adds them to the shared queue, 
//while the calculatorThread removes numbers from the
//queue and calculates the median of the remaining numbers.
//To ensure that the threads do not access the queue
//simultaneously, both threads synchronize on the queue
//object using the synchronized keyword. This ensures
//that only one thread can enter the critical section
//of code at a time, preventing race conditions and
//ensuring the integrity of the data in the queue.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class SharedQueueExample {

    public static void main(String[] args) {
        // Create a shared queue
        Queue<Integer> queue = new LinkedList<>();

        // Create a thread that generates random numbers and adds them to the queue
        Thread generatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Generate a random number
                    int number = random.nextInt();

                    // Synchronize on the queue to ensure that only one thread can access it at a time
                    synchronized (queue) {
                        // Add the number to the queue
                        queue.add(number);
                    }

                    // Sleep for a random amount of time
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Create a thread that removes numbers from the queue and calculates the median
        Thread calculatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Synchronize on the queue to ensure that only one thread can access it at a time
                    synchronized (queue) {
                        // Calculate the median of the numbers in the queue
                        int size = queue.size();
                        if (size > 0) {
                            int[] numbers = new int[size];
                            for (int i = 0; i < size; i++) {
                                numbers[i] = queue.poll();
                            }
                            int median;
                            if (size % 2 == 0) {
                                median = (numbers[size / 2 - 1] + numbers[size / 2]) / 2;
                            } else {
                                median = numbers[size / 2];
                            }
                            
                            System.out.println("Median: " + median);
                            
                        }
                    }

                    // Sleep for a random amount of time
                    try {
                        Thread.sleep(random.nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Start the threads
        generatorThread.start();
        calculatorThread.start();
    }
}
