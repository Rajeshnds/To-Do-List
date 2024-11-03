// import java.util.concurrent.CompletableFuture;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class OddEvenWithCustomExecutor {
//     private int counter = 1;
//     private static final int LIMIT = 10;

//     public static void main(String[] args) {
//         OddEvenWithCustomExecutor printer = new OddEvenWithCustomExecutor();
//         ExecutorService executor = Executors.newFixedThreadPool(2);

//         // Running tasks asynchronously with a custom executor
//         CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> printer.printNumbers(true), executor);
//         CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> printer.printNumbers(false), executor);

//         // Wait for both tasks to complete
//         CompletableFuture.allOf(oddTask, evenTask).join();

//         executor.shutdown();
//     }

//     public synchronized void printNumbers(boolean isOdd) {
//         while (counter <= LIMIT) {
//             if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
//                 System.out.println(Thread.currentThread().getName() + ": " + counter);
//                 counter++;

//                 try {
//                     Thread.sleep(100);
//                 } catch (InterruptedException e) {
//                     Thread.currentThread().interrupt();
//                 }
//             }
//         }
//     }
// }




import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenWithCustomExecutor {
    private int counter = 1;
    private static final int LIMIT = 10;

    public static void main(String[] args) {
        OddEvenWithCustomExecutor printer = new OddEvenWithCustomExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Running tasks asynchronously with a custom executor
        CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> printer.printNumbers(true), executor);
        CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> printer.printNumbers(false), executor);

        // Wait for both tasks to complete
        CompletableFuture.allOf(oddTask, evenTask).join();

        executor.shutdown();
    }

    public synchronized void printNumbers(boolean isOdd) {
        while (counter <= LIMIT) {
            // Check if the current thread should print (odd or even)
            if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;

                // Notify the other thread to wake up and check the condition
                notify();

                try {
                    // Pause to allow the other thread to proceed
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                try {
                    // Wait if it's not this thread's turn
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        // Final notify to make sure any waiting thread can complete if needed
        notifyAll();
    }
}
