import java.net.*;
import java.io.*;
import java.sql.SQLOutput;

public class MyHTTPClient {
    public static void main(String[] args){
        try{
            Socket sock = new Socket("127.0.0.1", 2024);
            InputStream in =sock.getInputStream();

            BufferedReader bin= new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line=bin.readLine())!=null){
                System.out.println(line);
                sock.close();
            }
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}
