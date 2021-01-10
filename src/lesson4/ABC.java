package lesson4;

public class ABC {
    private static final Object mon = new Object();
    private static volatile char letter = 'A';
    public static void PrintABC(int amount) {
        new Thread(() -> {
            try {
                for (int i = 0; i < amount; i++) {
                    synchronized (mon) {
                        while (letter != 'A') {
                            mon.wait();
                        }
                        System.out.print("A");
                        letter = 'B';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < amount; i++) {
                    synchronized (mon) {
                        while (letter != 'B') {
                            mon.wait();
                        }
                        System.out.print("B");
                        letter = 'C';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < amount; i++) {
                    synchronized (mon) {
                        while (letter != 'C') {
                            mon.wait();
                        }
                        System.out.print("C");
                        letter = 'A';
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
