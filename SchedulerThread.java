import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.sun.net.httpserver.Request;

class SchedulerThread extends Thread {
    private final BlockingQueue<Request> requestQueue;
    private final ThreadPool threadPool;
    private volatile boolean done = false;

    public SchedulerThread(LinkedBlockingQueue<Request> requestQueue, ThreadPool threadPool) {
        this.requestQueue = this.requestQueue;
        this.threadPool = this.threadPool;
    }

    @Override
    public void run() {
        while (!done) {
            try {
                Request request = requestQueue.take();
                if (done && request == null) {
                    return; // Exit if done and queue is empty
                }
                // Dispatch the request to a worker thread
                threadPool.dispatchToWorker(() -> processRequest(request));
            } catch (InterruptedException e) {
                // Handle interruption
                Thread.currentThread().interrupt(); // Restore interruption status
            }
        }
    }

    public void shutdown() {
        done = true;
        interrupt(); // To ensure the thread stops waiting
    }

    private void processRequest(Request request) {
        // Implement request processing logic here
    }
}
