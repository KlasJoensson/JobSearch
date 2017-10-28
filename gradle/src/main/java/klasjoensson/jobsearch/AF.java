package klasjoensson.jobsearch;

import klasjoensson.jobsearch.util.HttpRequest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * This class handles the calls to Arbetsförmedlingen.
 *
 * Created by Klas Jönsson on 2017-10-12.
 */
public class AF {

    private static final String BASE_URL = "http://api.arbetsformedlingen.se/af/v0";

    /**
     * To get a search list with the Swedish 'län'.
     *
     * @return A JSON String containing information of all counties
     */
    public static String getCounties() {

        String url = BASE_URL + "/platsannonser/soklista/lan";

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a search list with the Swedish 'län' including foreign ads.
     *
     * @return A JSON String containing information of all counties and foreign countries
     */
    public static String getAllCounties() {

        String url = BASE_URL + "/platsannonser/soklista/lan2";

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a search list with all 'kummuner' in a 'län'.
     *
     * @param countyId The id of the wanted 'län'
     *
     * @return A JSON String containing information of all counties
     */
    public static String getShires(int countyId) {

        String url = BASE_URL + "/platsannonser/kommuner?lanid=" + countyId;

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a list with the predefined profession areas.
     *
     * @return A JSON object containing information of all counties
     */
    public static String getProfessionAreas() {

        String url = BASE_URL + "/platsannonser/soklista/yrkesomraden";

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a list with the predefined profession groups for a profession area.
     *
     * @param professionAreaId The id of the wanted profession area
     *
     * @return A JSON String containing information of all counties
     */
    public static String getProfessionGroups(int professionAreaId) {

        String url = BASE_URL + "/platsannonser/soklista/yrkesgrupper?yrkesomradeid=" + professionAreaId;

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a list with the predefined professions for a profession group.
     *
     * @param professionGroupId The id of the wanted profession group
     *
     * @return A JSON String containing information of all counties
     */
    public static String getProfessions(int professionGroupId) {

        String url = BASE_URL + "/platsannonser/soklista/yrken?yrkesgruppid=" + professionGroupId;

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * To get a list with the predefined professions witch names starts with the argument string.
     *
     * @param name The name or first part of the name of the vanted professions
     *
     * @return A JSON String containing a list with the fount professions
     */
    public static String searchProfessions(String name) {

        String url = BASE_URL + "/platsannonser/soklista/yrken/" + name;

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * Search for job ads that matches the arguments.
     * Page and rows are used for pagination, ex. if the total number of ads are 20 and rows are set to 10 and page
     * is set to 2 then it will return ad number 11 to 20.
     *
     * @param countyIds The ids of the wanted 'län', if all is wanted in the search set to null
     * @param shiresIds The ids of the wanted 'kommuner', if all is wanted in the search set to null
     * @param professionIds The ids of the wanted professions, if all is wanted in the search set to null
     * @param keywords The keywords to search for
     * @param page Witch pages to be retrieved, if set 0 it defaults to 1
     * @param rows The number of rows per page, if set 0 it defaults to 20
     * @return One page of ads
     */
    public static String searchForAds(Integer[] countyIds, Integer[] shiresIds, Integer[] professionIds,
                                      String[] keywords, int page, int rows) throws UnsupportedEncodingException {

        StringBuilder url = new StringBuilder(BASE_URL);
        url.append("/platsannonser/matchning?");
        boolean firstArg = true;
        if (countyIds != null && countyIds.length > 0) {
            url.append(getQueryPart("lanid", countyIds));
            firstArg = false;
        }
        if (shiresIds != null && shiresIds.length > 0) {
            if (!firstArg) {
                url.append("&");
            } else {
                firstArg = false;
            }
            url.append(getQueryPart("kommunid", shiresIds));
        }
        if (professionIds != null && professionIds.length >0) {
            if (!firstArg) {
                url.append("&");
            } else {
                firstArg = false;
            }
            url.append(getQueryPart("yrkesid", professionIds));
        }
        if (keywords != null && keywords.length >0) {
            if (!firstArg) {
                url.append("&");
            } else {
                firstArg = false;
            }
            url.append( getQueryPart("nyckelord", keywords));
        }
        if (page > 0) {
            if (!firstArg) {
                url.append("&");
            } else {
                firstArg = false;
            }
            url.append("sida=");
            url.append(page);
        }
        if (rows > 0) {
            if (!firstArg) {
                url.append("&");
            }
            url.append("antalrader=");
            url.append(rows);
        }

        try {
            return HttpRequest.get( url.toString() );

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    private static String getQueryPart(String queryPart, Object[] queryList) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder(queryPart);
        url.append("=");

        StringBuilder subUrl = new StringBuilder();
        for (Object id:queryList){
            subUrl.append(id);
            subUrl.append(" ");
        }
        subUrl.deleteCharAt(subUrl.length()-1);

        url.append( URLEncoder.encode( subUrl.toString(), "UTF-8" ) );

        return url.toString();
    }

    /**
     * Gets a job ad.
     *
     * @param id The id of the wanted ad.
     *
     * @return The ad with the id in the argument
     */
    public static String getAd(int id) {

        String url = BASE_URL + "/platsannonser/" + id;

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

    /**
     * Gets the logotype associated with an job ad.
     *
     * @param id The id of the wanted ad.
     *
     * @return The logotype associated with an job ad
     */
    public static String getAdLogo(int id) {

        String url = BASE_URL + "/platsannonser/" + id  + "/logotyp/";

        try {
            return HttpRequest.get(url);

        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }

}
