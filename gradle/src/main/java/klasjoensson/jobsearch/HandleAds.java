package klasjoensson.jobsearch;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by klas on 2017-10-28.
 */
public class HandleAds {

    public static double rateAd(String adStr, String keys) {
        Map<String, Object> adMap = new Gson().fromJson(adStr, Map.class);
        Map<String, Object> jobAd = (Map<String, Object>) adMap.get("platsannons");
        Map<String, Object> ad = (Map<String, Object>) jobAd.get("annons");
        String description = (String) ad.get("annonstext");

        Map<String, Object> keyMap = new Gson().fromJson(keys, Map.class);
        int hits = 0;
        double rate = 0;
        for(String key:keyMap.keySet()) {
            if (description.contains(key)) {
                hits++;
                rate += (double) keyMap.get(key);
            }
        }

        if(hits !=0)
            return rate/hits;
        else
            return 0;
    }
}
