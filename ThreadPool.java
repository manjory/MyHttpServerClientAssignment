import java.util.concurrent.*;

public class ThreadPool {
    private final ExecutorService executor;

    public ThreadPool(int nThreads) {
        executor = Executors.newFixedThreadPool(nThreads);
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
    public void dispatchToWorker(Runnable task) {
        executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
