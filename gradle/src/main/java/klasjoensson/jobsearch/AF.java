package klasjoensson.jobsearch;

import klasjoensson.jobsearch.util.HttpRequest;

/**
 * This class handles the calls to Arbetsförmedlingen.
 *
 * Created by Klas Jönsson on 2017-10-12.
 */
public class AF {

    private static final String BASE_URL = "http://api.arbetsformedlingen.se/af/v0";

    /**
     * To get a search list with the counties.
     *
     * @return A JSON object containing information of all counties
     */
    public static String getCounties() {

        String url = BASE_URL + "/platsannonser/soklista/lan";

        return HttpRequest.get(url);
    }

    /**
     * To get a search list with the counties including foreign countries.
     *
     * @return A JSON object containing information of all counties and foreign countries
     */
    public static String getAllCounties() {

        String url = BASE_URL + "/platsannonser/soklista/lan2";

        return HttpRequest.get(url);
    }
}
