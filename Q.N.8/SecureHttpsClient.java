// Write a program to create a Secure Https Client with the secure socket.

import javax.net.ssl.*;
import java.io.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class SecureHttpsClient {

     public static void main(String[] args) {
        String host = "www.google.com";
        int port = 443;

        try {
            TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() { return null; }
                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, trustAllCerts, new SecureRandom());

            SSLSocketFactory factory = context.getSocketFactory();
            SSLSocket socket = (SSLSocket) factory.createSocket(host, port);

            socket.startHandshake();

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("GET / HTTP/1.1\r\n");
            out.write("Host: " + host + "\r\n");
            out.write("Connection: close\r\n");
            out.write("\r\n");
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


   
    


