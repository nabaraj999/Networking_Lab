import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class PrintAllHttpHeaders {
    public static void main(String[] args ) throws Exception{
        // Replace with your desired URL
        URI uri = new URI("https://www.example.com");
        URL url = uri.toURL();
        URLConnection connection = url.openConnection();

        // Get all headers
        Map<String, List<String>> headers = connection.getHeaderFields();

        // Print all headers
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String headerName = entry.getKey();
            List<String> headerValues = entry.getValue();
            System.out.print((headerName != null ? headerName : "Status-Line") + ": ");
            for (int i = 0; i < headerValues.size(); i++) {
                System.out.print(headerValues.get(i));
                if (i < headerValues.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
