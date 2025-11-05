// Write a program that lists out all the network interfaces and use the method of 
// NetworkInterfaceClass to print the characteristics of all interfaces.

import java.net.NetworkInterface;
import java.util.Enumeration;


public class InterfaceChar {

   
    public static void main(String[] args) throws Exception {

       
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()) {

          
            NetworkInterface ni = interfaces.nextElement();

           
            System.out.println("Interface: " + ni.getName());

                      byte[] macAddress = ni.getHardwareAddress();
            if (macAddress != null) {
                
                StringBuilder mac = new StringBuilder();
                for (byte b : macAddress) {
                    mac.append(String.format("%02X:", b)); // Convert each byte to a 2-digit hexadecimal value.
                }
                if (mac.length() > 0) {
                    mac.deleteCharAt(mac.length() - 1); // Remove the trailing ":" at the end.
                }
                System.out.println("MAC: " + mac.toString());
            } else {
                System.out.println("MAC: Not Available"); // If no MAC address is found.
            }
        }
    }
}




