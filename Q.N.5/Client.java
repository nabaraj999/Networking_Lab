    import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String host = "localhost"; // or use server IP
        int port = 80;

        try {
            // Connect to server
            Socket socket = new Socket(host, port);
            System.out.println("Connected to the server.");

            // Send request to server
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Send me the time");

            // Read response from server
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String serverResponse = reader.readLine();
            System.out.println("Server says: " + serverResponse);

            socket.close();
        } catch (IOException ex) {
            System.out.println("Client error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

    
