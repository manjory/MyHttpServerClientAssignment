import java.net.*;
import java.io.*;

public class ClientHandler implements Runnable {
    private Socket client;

    public ClientHandler(Socket clientSocket) {
        this.client = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String requestLine;
            while ((requestLine = in.readLine()) != null) {
                System.out.println(requestLine);
                if (requestLine.isEmpty()) {
                    break;
                }
            }

            out.println("HTTP/1.0 200 OK");
            out.println("Content-Type: text/html");
            out.println();
            out.println("<html><body><h1>Hello, World!</h1></body></html>");

            client.close();
        } catch (IOException e) {
            System.err.println("IOException in ClientHandler: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
