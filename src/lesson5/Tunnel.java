package lesson5;

import java.util.concurrent.Semaphore;

class Tunnel extends Stage {

    private Semaphore smp;

    public Tunnel(int carsLimit) {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
        smp = new Semaphore(carsLimit);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                smp.acquire();
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                smp.release();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}