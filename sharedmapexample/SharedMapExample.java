package sharedmapexample;
//In this example, the generatorThread generates
//random numbers and adds them to the shared map, 
//while the calculatorThread removes numbers 
//from the map and calculates the average of the 
//remaining numbers. To ensure that the threads 
//do not access the map simultaneously, both threads
//synchronize on the map object using the synchronized keyword. 
//This ensures that only one thread can enter the critical section
//of code at a time, preventing race conditions and 
//ensuring the integrity of the data in the map.

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SharedMapExample {

    public static void main(String[] args) {
        // Create a shared map
        Map<Integer, Integer> map = new HashMap<>();

        // Create a thread that generates random numbers and adds them to the map
        Thread generatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Generate a random number
                    int number = random.nextInt();

                    // Synchronize on the map to ensure that only one thread can access it at a time
                    synchronized (map) {
                        // Add the number to the map
                        map.put(number, number);
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

        // Create a thread that removes numbers from the map and calculates the average
        Thread calculatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Synchronize on the map to ensure that only one thread can access it at a time
                    synchronized (map) {
                        // Calculate the average of the numbers in the map
                        int sum = 0;
                        int count = 0;
                        for (int number : map.values()) {
                            sum += number;
                            count++;
                        }
                        double average = (double) sum / count;
                        System.out.println("Average: " + average);

                        // Remove a random number from the map
                        if (!map.isEmpty()) {
                            int keyToRemove = (int) map.keySet().toArray()[0];
                            map.remove(keyToRemove);
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
