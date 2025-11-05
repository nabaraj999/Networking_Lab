// Write a program that show all the info of client socket using methods like 
// socket.getInetAddress(), socket.getLocalPort() etc.

import java.io.IOException;
import java.net.*;

public class SocketInfo {
    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[] { "localhost" };
        }
        for (int i = 0; i < args.length; i++) {
            try {
                Socket socket = new Socket(args[i], 80);
                System.out.println("Connected to :" + socket.getInetAddress()
                        + " on port " + socket.getPort() +
                        " from port " + socket.getLocalPort() + " of socket"
                        + socket.getLocalAddress());
                socket.close();
            } catch (UnknownHostException e) {
                System.err.println("No address found " + args[i]);
            } catch (SocketException e) {
                System.err.println("Could not connect to " + args[i]);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

