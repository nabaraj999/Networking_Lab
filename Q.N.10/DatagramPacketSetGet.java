import java.net.*;

public class DatagramPacketSetGet {
    public static void main(String[] args) throws Exception {
        
        byte[] data = "Data".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(data, data.length, address, 3000);

        System.out.println("Data: " + new String(packet.getData(), packet.getOffset(), packet.getLength()));
        System.out.println("Address: " + packet.getAddress());
        System.out.println("Port: " + packet.getPort());

        
        packet.setData("Data".getBytes());
        packet.setPort(4000);

        
        System.out.println("Updated Data: " + new String(packet.getData(), packet.getOffset(), packet.getLength()));
        System.out.println("Updated Port: " + packet.getPort());
    }
}
