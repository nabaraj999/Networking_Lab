import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public static void main(String[] args) {
        int port = 80;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Read message from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = reader.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Get current time
            LocalDateTime now = LocalDateTime.now();
            String currentTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

            // Send time back to client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Current time is: " + currentTime);

            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
