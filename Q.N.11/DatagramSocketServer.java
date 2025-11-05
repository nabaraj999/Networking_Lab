import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramSocketServer {
    public static void main(String[] args) {
        final int PORT = 3000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server started on port " + PORT);

            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(requestPacket);

                String receivedMsg = new String(requestPacket.getData(), 0, requestPacket.getLength());
                System.out.println("Received from client: " + receivedMsg);

                // Simple echo response
                byte[] responseData = ("Server got: " + receivedMsg).getBytes();
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
