package klasjoensson.jobsearch.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsibly for making HTTP requests.
 *
 * Created by Klas Jönsson on 2017-10-12.
 */
public class HttpRequest {

    public static String get(String urlStr) throws IOException {

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Accept-Language", "sv");
        conn.setDoInput(true);
        conn.setDoOutput(true);

        BufferedReader br;
        if (conn.getResponseCode() != 200) {
            Map<String, Object> errorMap = new HashMap<>();
            errorMap.put("Error", "Server error" );
            errorMap.put("Code", conn.getResponseCode() );
            errorMap.put("Message", conn.getResponseMessage()  );

            throw new IOException("Server response: [" + conn.getResponseCode() + "] " + conn.getResponseMessage() );
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

    }
}
