

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceCounter {
    private AtomicInteger counter = new AtomicInteger(0);

    /**
     * Initializes the two threads and starts the counter.
     *
     * @param countTo The number to count up to. Also the number of threads to create.
     */
    public void startCounter(int countTo) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < countTo; i++) {
            executorService.submit(() -> {
                counter.addAndGet(1);
            });
        }

        executorService.shutdown();
    }

    /**
     * Used to retrieve the current value of counter.
     * @return The current value of the counter.
     */
    public AtomicInteger getCounter() {
        return this.counter;
    }
}
