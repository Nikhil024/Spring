import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("http://localhost:1234/eShopApp/details"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {               
                JSONArray a = (JSONArray) parser.parse(inputLine);
                
                // Loop through each item
                for (Object o : a) {
                    JSONObject tutorials = (JSONObject) o;

                    String status = (String) tutorials.get("status");
                    System.out.println("status : " + status);

                    String device = (String) tutorials.get("device");
                    System.out.println("device: " + device);
                    
                    
                    String manufacturer = (String) tutorials.get("manufacturer");
                    System.out.println("manufacturer : " + 	);

                    System.out.println("\n");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }   
    }   
}