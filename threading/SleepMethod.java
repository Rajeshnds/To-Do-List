public class SleepMethod {
    private int counter = 1;
    private static final int LIMIT = 10;

    public static void main(String[] args) {
        SleepMethod printer = new SleepMethod();

        Thread oddThread = new Thread(() -> printer.printNumbers(true), "OddThread");
        Thread evenThread = new Thread(() -> printer.printNumbers(false), "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    public void printNumbers(boolean isOdd) {
        while (counter <= LIMIT) {
            synchronized (this) {
                if ((counter % 2 == 1 && isOdd) || (counter % 2 == 0 && !isOdd)) {
                    System.out.println(Thread.currentThread().getName() + ": " + counter);
                    counter++;

                    try {
                        // Adding sleep to simulate delay
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            // Sleep outside synchronized block to allow other thread to acquire the lock
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
