// Write a program that gets the localhost IP address, canonical name using InetAddress methods.
    import java.net.*;

    public class InetAddressth {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            //System.out.println(address);
            System.out.println(address.getHostAddress());
           // System.out.println(address.getHostName());
            System.out.println(address.getCanonicalHostName());
           // System.out.println(address.getAddress());
        } catch (UnknownHostException e) {
            System.out.println("Error Caught: " + e.getMessage());
        }
    }
}
    

