package metricsConverter;

import api.requester.Requester;
import api.requester.RequesterImpl;
import org.json.JSONObject;

public class MetricsConverterImpl implements MetricsConverter {
    private static int TIME_UNIT = 60;
    private static double TEMP_UNIT = 273.15;

    private Requester requester;

    public MetricsConverterImpl(){
        requester = new RequesterImpl();
    }

    @Override
    public double convertTemperature(double temperature) {
        return Math.floor(temperature - TEMP_UNIT);
    }

    @Override
    public String convertTimeZone(int timeZone) {
        int hoursOffset = timeZone/TIME_UNIT/TIME_UNIT;
        JSONObject r = requester.getJsonFromURL("http://worldclockapi.com/api/json/utc/now");
        String rawTime = (String) r.query("/currentDateTime");

        //input: 2020-06-08T21:03Z necessary to get 21:03
        String time = rawTime.substring(rawTime.indexOf("T") + 1, rawTime.indexOf("Z"));
        String[] hoursMinutes = time.split(":");
        int hours = Integer.parseInt(hoursMinutes[0]);
        int currentHours = hours + hoursOffset;

        if(currentHours >= 24){
            currentHours -= 24;
        }

        return currentHours + ":" + hoursMinutes[1];
    }

}
