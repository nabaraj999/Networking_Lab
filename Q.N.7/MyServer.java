import java.net.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class MyServer {
    public final static int PORT = 3000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Daytime Server started on port " + PORT);
            while (true) {
                try {
                    Socket connection = server.accept();
                    System.out.println("Connection established from " + connection.getInetAddress() + ":" + connection.getPort());

                    Thread task = new DaytimeThread(connection);
                    task.start();
                } catch (IOException e) {
                    System.err.println("Connection error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public static class DaytimeThread extends Thread {
        private Socket connection;

        DaytimeThread(Socket connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            ) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("stop".equalsIgnoreCase(inputLine.trim())) {
                        break;
                    }

                    try {
                        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(inputLine));
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
                        String formattedTime = zonedDateTime.format(formatter);
                        out.println("Current time in " + inputLine + ": " + formattedTime);
                    } catch (Exception e) {
                        out.println("Invalid timezone: " + inputLine);
                    }
                }
            } catch (IOException e) {
                System.err.println("Thread error: " + e.getMessage());
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    System.err.println("Closing error: " + e.getMessage());
                }
            }
        }
    }
}
