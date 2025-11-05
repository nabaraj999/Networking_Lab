  // Write a program that prints all arbitrary HTTP headers. 
  
  import java.io.IOException;
  import java.net.*;
import java.sql.Date;

public class HTTPHeader {
    public static void main(String[] args) throws IOException {
        try {
          URI uri = new URI("https://www.example.com");
            URL url = uri.toURL();
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host : " + url.getHost());
            System.out.println("Port : " + url.getPort());
            System.out.println("File : " + url.getFile());
            System.out.println("Authority : " + url.getAuthority());
            System.out.println("Query : " + url.getQuery());
            System.out.println("DefaultPort : " + url.getDefaultPort());
            System.out.println("Ref : " + url.getRef());
            System.out.println("URI : " + url.toURI());
            System.out.println("String Conversion : " + url.toString());


            
            URLConnection connection = url.openConnection();
            int contentLength = connection.getContentLength();
            String contentType = connection.getContentType();
            Date date = new Date(connection.getDate()) ;
            Date modifieddate = new Date(connection.getLastModified());

            System.out.println(date);
            System.out.println(modifieddate);
            System.out.println(contentType);
            System.out.println("Content-Length: " + contentLength);
 

        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        }
    }
}
    

