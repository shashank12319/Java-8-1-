package standarddeviation;
//Here is a sample Java program that creates two 
// that access a shared set of random numbers. 
//The first thread generates random numbers and adds 
//them to the set, while the second thread removes
//numbers from the set and calculates the standard
//deviation. The set is synchronized using a
//ReentrantLock to ensure that the threads
//do not access it simultaneously.
//This program creates two threads: a generatorThread
//that generates random numbers and adds them to the
//shared set, and a standardDeviationThread that
//removes numbers from the set and calculates the
//standard deviation. The threads access the set 
//Simultaneously, so we use the ReentrantLock 
//to synchronize access to it. The lock.lock()
//method is used to acquire the lock, and the
//lock.unlock() method is used to release it.
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*
;public class StandardDeviation {

    // shared set of random numbers
    private static Set<Double> numbers = new ConcurrentSkipListSet<>();

    // lock for synchronizing access to the set
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        // create and start the first thread
        Thread generatorThread = new Thread(() -> {
            Random random = new Random();
            while (true) {
                double number = random.nextDouble();
                lock.lock();
                try {
                    numbers.add(number);
                } finally {
                    lock.unlock();
                }
            }
        });
        generatorThread.start();

        // create and start the second thread
        Thread standardDeviationThread = new Thread(() -> {
            while (true) {
                lock.lock();
                try {
                    if (!numbers.isEmpty()) {
                        double sum = 0;
                        for (double number : numbers) {
                            sum += number;
                        }
                        double mean = sum / numbers.size();
                        double sumOfSquares = 0;
                        for (double number : numbers) {
                            sumOfSquares += (number - mean) * (number - mean);
                        }
                        double standardDeviation = Math.sqrt(sumOfSquares / numbers.size());
                        System.out.println("Standard deviation: " + standardDeviation);
                        numbers.clear();
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        standardDeviationThread.start();

        // wait for the threads to finish
        generatorThread.join();
        standardDeviationThread.join();
    }
}
