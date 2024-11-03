public class SynchronizedMethod {
    private final Object lock = new Object();
    private int counter = 1;
    private static final int LIMIT = 10;

    public static void main(String[] args) {
        SynchronizedMethod printer = new SynchronizedMethod();

        Thread oddThread = new Thread(() -> printer.printNumbers(true));
        Thread evenThread = new Thread(() -> printer.printNumbers(false));

        oddThread.start();
        evenThread.start();
    }

    public void printNumbers(boolean isOdd) {
        while (counter <= LIMIT) {
            synchronized (lock) {
                if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
                    System.out.println((isOdd ? "Odd: " : "Even: ") + counter);
                    counter++;
                    lock.notify(); // Notify the other thread to continue

                    try {
                        if (counter <= LIMIT) { 
                            lock.wait(); // Wait if there are still numbers to print
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    // If it's not this thread's turn, release the lock and wait
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
