// Write a program that downloads WebPage with UrlConnection class. Your output on the 
// lab report should consist of a few lines of output. 
  import java.net.*;
import java.io.*;

public class WebPageDounload {
    public static void main(String[] args) throws URISyntaxException {
        try {
            // Specify the URL
            URI uri = new URI("http://example.com");
            URL url = uri.toURL();

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Create a reader to read the input stream
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            int lineCount = 0;

            System.out.println("First few lines of webpage content:");

            // Print the first 5 lines of the webpage
            while ((inputLine = in.readLine()) != null && lineCount < 5) {
                System.out.println(inputLine);
                lineCount++;
            }

            in.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

    
