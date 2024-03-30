
import java.net.HttpURLConnection;
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
public class CheckWeb {
    public static void main(String[] args) {
         String[] webs = {
        "https://www.vng.com.vn/",
        "https://www.fujinet.net/",
        "https://huflit.edu.vn/"
           };
         
         for(String s: webs){
             checkWeb(s);
         }
    }
    
    public static void checkWeb(String urlString){
        try {
            URL url = new URI(urlString).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // http code : 200, 401, 403, 404, 500, 501
            int responeCode = connection.getResponseCode();
            if(responeCode == 200){
                System.out.println(urlString + " is active ");
            }
            else{
                System.out.println(urlString+ " is not working "+ ". Code: "+responeCode);
            }
        } catch (Exception e) {
            System.out.println(urlString + " cannot connect");
        }
    }
   
    
    
}
