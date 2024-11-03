public class Threading {
    private final Object lock = new Object();
    private boolean isOddTurn = true;

    public static void main(String[] args) {
        Threading printer = new Threading();
        
        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }

    public void printOdd() {
        for (int i = 1; i <= 10; i += 2) {
            synchronized (lock) {
                while (!isOddTurn) { // Wait if it's not the odd turn
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Odd: " + i);
                isOddTurn = false; // Switch turn to even
                lock.notify(); // Notify the even thread
            }
        }
    }

    public void printEven() {
        for (int i = 2; i <= 10; i += 2) {
            synchronized (lock) {
                while (isOddTurn) { // Wait if it's not the even turn
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Even: " + i);
                isOddTurn = true; // Switch turn to odd
                lock.notify(); // Notify the odd thread
            }
        }
    }
}
