package lesson5;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * homework lesson5
 *
 * @author Amina
 * 15.04.2021
 */
public class Car implements Runnable{
    private static int CARS_COUNT;
    private Race race;
    private long speed;
    private String name;
    private static AtomicBoolean  winner = new AtomicBoolean(false);
    CyclicBarrier cb;

    public String getName() {
        return name;
    }

    public long getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        this.cb = cb;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        try {
            race.lock.lock();
            if (!winner.getAndSet(true)) {
                System.out.println(name + " победитель!!! Расчетное время прибытия: "+  new Date(System.currentTimeMillis()));
            } else System.out.println(name + " финишировал. Расчетное время прибытия:"+ new Date(System.currentTimeMillis()));
        } finally {
            race.lock.unlock();
        }
        try {
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
