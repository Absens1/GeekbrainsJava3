package lesson5;

import java.util.concurrent.*;

public class Car implements Runnable {

    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private static CyclicBarrier cb;
    private static boolean checkWin;

    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
            cb.await();
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            cb.await();
            checkWinner(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static synchronized void checkWinner(Car c) {
        if (!checkWin) {
            System.out.println(c.name + " - WIN");
            checkWin = true;
        }
    }
}
