// Write a program that illustrates the socket client and Socket Server using the UDP DatagramSocket class. 

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class DatagramSocketClient {
    public static void main(String[] args) {
        final int PORT = 3000;
        final String SERVER = "localhost";
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter message for server (or 'exit' to quit): ");
                String input = scanner.nextLine().trim();

                if (input.equalsIgnoreCase("exit"))
                    break;

                byte[] data = input.getBytes();
                DatagramPacket requestPacket = new DatagramPacket(data, data.length,
                        InetAddress.getByName(SERVER), PORT);
                socket.send(requestPacket);

                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("Server response: " + response);
            }
        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}



