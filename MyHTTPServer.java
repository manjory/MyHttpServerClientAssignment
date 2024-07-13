import java.net.*;
import java.io.*;

public class MyHTTPServer {
    public static void main(String[] args){
        try{
            ServerSocket sock = new ServerSocket(2024);
            while (true){
                Socket client = sock.accept();
                PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                out.println("I am the client");
                client.close();
            }

        }
        catch (IOException e){
            System.err.println("IOException" +e.getMessage());
        }
    }
}
