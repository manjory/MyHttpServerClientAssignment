import java.net.*;
import java.io.*;

public class MyHTTP {
    public static void main(String[] args) {
        int port = 2024;
        int threadPoolSize = 10; // Number of worker threads
        ThreadPool threadPool = new ThreadPool(threadPoolSize);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            // Listen for connections
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected");

                // Submit the client handler task to the thread pool
                threadPool.execute(new ClientHandler(client));
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            threadPool.shutdown();
        }
    }
}
