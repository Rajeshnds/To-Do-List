// import java.util.concurrent.CompletableFuture;

// public class OddEvenWithAsync {
//     private int counter = 1;
//     private static final int LIMIT = 10;

//     public static void main(String[] args) {
//         OddEvenWithAsync printer = new OddEvenWithAsync();

//         // Running tasks asynchronously
//         CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> printer.printNumbers(true));
//         CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> printer.printNumbers(false));

//         // Wait for both tasks to complete
//         CompletableFuture.allOf(oddTask, evenTask).join();
//     }

//     public synchronized void printNumbers(boolean isOdd) {
//         while (counter <= LIMIT) {
//             if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
//                 System.out.println(Thread.currentThread().getName() + ": " + counter);
//                 counter++;

//                 // Adding sleep to simulate delay and allow other task to progress
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

public class OddEvenWithAsync {
    private int counter = 1;
    private static final int LIMIT = 10;

    public static void main(String[] args) {
        OddEvenWithAsync printer = new OddEvenWithAsync();

        // Running tasks asynchronously
        CompletableFuture<Void> oddTask = CompletableFuture.runAsync(() -> printer.printNumbers(true));
        CompletableFuture<Void> evenTask = CompletableFuture.runAsync(() -> printer.printNumbers(false));

        // Wait for both tasks to complete
        CompletableFuture.allOf(oddTask, evenTask).join();
    }

    public synchronized void printNumbers(boolean isOdd) {
        while (counter <= LIMIT) {
            // Check if the current thread is supposed to print
            if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
                System.out.println(Thread.currentThread().getName() + ": " + counter);
                counter++;

                // Notify the other thread to wake up and check the condition
                notify();

                // Adding sleep to simulate delay and allow other task to progress
                try {
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
        // Final notify to ensure any waiting thread can complete if needed
        notifyAll();
    }
}
