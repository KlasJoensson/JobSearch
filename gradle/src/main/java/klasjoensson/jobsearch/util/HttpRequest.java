package klasjoensson.jobsearch.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is responsibly for making HTTP requests.
 *
 * Created by Klas Jönsson on 2017-10-12.
 */
public class HttpRequest {

    public static String get(String urlStr) {

        System.out.println(urlStr);

        try {

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Accept-Language", "sv");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            BufferedReader br;
            if (conn.getResponseCode() != 200) {
                // TODO Fix better error handling
                br = new BufferedReader(new InputStreamReader(
                        (conn.getErrorStream())));
            } else {
                br = new BufferedReader(new InputStreamReader(
                        (conn.getInputStream())));
            }

            String output;
            StringBuilder result = new StringBuilder();
            while ((output = br.readLine()) != null) {
                result.append(output);
            }

            conn.disconnect();

            return result.toString();

        } catch (MalformedURLException e) {

            e.printStackTrace();
            return "Error: MalformedURLException (see std output for more info...";

        } catch (IOException e) {

            e.printStackTrace();
            return "Error: IOException (see std output for more info...";

        }
    }
}
