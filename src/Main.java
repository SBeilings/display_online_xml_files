import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        final String PLANT_CATALOG = "https://www.w3schools.com/xml/plant_catalog.xml";
        BufferedInputStream bufferedInputStream = null;
        InputStream stream = null;

        try {
            URL url = new URL(PLANT_CATALOG);
            StringBuilder br = new StringBuilder();
            stream = url.openStream();
            bufferedInputStream = new BufferedInputStream(stream);

            while(true){
                int data = bufferedInputStream.read();
                if (data == -1){
                    break;
                }else{
                    br.append((char)data);
                }
                System.out.println(br);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            bufferedInputStream.close();
            stream.close();
        }

    }
}
