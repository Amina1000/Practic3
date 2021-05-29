package lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * homework lesson5
 *
 * @author Amina
 * 15.04.2021
 */
public class Race {
    private ArrayList<Stage> stages;
    Lock lock = new ReentrantLock();
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
