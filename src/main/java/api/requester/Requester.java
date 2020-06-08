package api.requester;
import org.json.JSONObject;

import java.net.MalformedURLException;

public interface Requester {
    JSONObject getJsonFromURL(String url);
    String getDataFromURL(String url);
}
