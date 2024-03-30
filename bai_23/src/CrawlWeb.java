
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiso
 */
public class CrawlWeb {
    public static void main(String[] args) {
        try {
            String urlString = "https://www.fujinet.net";
            URL url = new URI(urlString).toURL();
            InputStreamReader inputStream = new InputStreamReader(url.openStream());
            BufferedReader br = new BufferedReader(inputStream);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
