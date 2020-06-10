package api.requester;

import api.mapping.MapperImpl;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

//https://api.openweathermap.org/data/2.5/weather?q=London&appid=330a370093d85a95a83474ca5483c00c
@Component
public class RequesterImpl implements Requester{

    private static Logger logger = LoggerFactory.getLogger(RequesterImpl.class);

    @Override
    public JSONObject getJsonFromURL(String url){
        return new JSONObject(getDataFromURL(url));
    }

    @Override
    public String getDataFromURL(String url) {
        StringBuilder result = new StringBuilder();

        try {
            URL webUrl = new URL(url);
            Scanner input = new Scanner((InputStream) webUrl.getContent());

            while (input.hasNext()){
                result.append(input.nextLine());
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return result.toString();
    }
}
