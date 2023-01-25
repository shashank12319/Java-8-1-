package sharedListExample;

//In this example, the generatorThread generates
//random strings and adds them to the shared list
 //while the calculatorThread removes strings from 
 //the list and calculates the number of vowels in 
 //each string. To ensure that the threads do not
 //access the list simultaneously, both threads 
 //synchronize on the list object using the synchronized
 //keyword. This ensures that only one thread can enter
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SharedListExample {

    public static void main(String[] args) {
        // Create a shared list
        List<String> list = new ArrayList<>();

        // Create a thread that generates random strings and adds them to the list
        Thread generatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Generate a random string
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 5; i++) {
                        char c = (char) (random.nextInt(26) + 'a');
                        sb.append(c);
                    }
                    String str = sb.toString();

                    // Synchronize on the list to ensure that only one thread can access it at a time
                    synchronized (list) {
                        // Add the string to the list
                        list.add(str);
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

        // Create a thread that removes strings from the list and calculates the number of vowels in each string
        Thread calculatorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                while (true) {
                    // Synchronize on the list to ensure that only one thread can access it at a time
                    synchronized (list) {
                        // Calculate the number of vowels in the first string in the list
                        if (!list.isEmpty()) {
                            String str = list.get(0);
                            int count = 0;
                            for (int i = 0; i < str.length(); i++) {
                                int c = str.charAt(i);
                                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                                    count++;
                                }
                            }
                            System.out.println("The string generated is " +str);
                            System.out.println("Number of vowels: " + count);

                            // Remove the first string from the list
                            list.remove(0);
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
