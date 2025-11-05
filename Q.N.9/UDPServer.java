
import java.net.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class UDPServer {
    public static void main(String[] args) {
        final int PORT = 3000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP Daytime Server started on port " + PORT);

            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String timezone = new String(requestPacket.getData(), 0, requestPacket.getLength()).trim();

                String responseText;
                try {
                    ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of(timezone));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
                    responseText = "Time in " + timezone + ": " + zonedDateTime.format(formatter);
                } catch (Exception e) {
                    responseText = "Invalid timezone: " + timezone;
                }

                byte[] responseData = responseText.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData,
                        responseData.length,
                        requestPacket.getAddress(),
                        requestPacket.getPort()
                );

                socket.send(responsePacket);
            }
        } catch (Exception e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
