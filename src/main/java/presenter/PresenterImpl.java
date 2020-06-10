package presenter;

import com.vdurmont.emoji.EmojiParser;
import metricsConverter.MetricsConverter;
import model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PresenterImpl implements Presenter {

    @Autowired
    private MetricsConverter converter;

    @Override
    public String getPresentation(Forecast forecast) {
        return "Country: " + forecast.getCountry() + " " + EmojiParser.parseToUnicode(":" + forecast.getCountry().toLowerCase() + ":") + "\n" +
                "City: " + forecast.getCityName() + "\n" +
                "Weather: " + forecast.getWeatherDescription() + "\n" +
                "Temperature: " + converter.convertTemperature(forecast.getTemperature()) + "C" + "\n" +
                "Min temperature: " + converter.convertTemperature(forecast.getMinTemp()) + "C" + "\n" +
                "Max temperature: " + converter.convertTemperature(forecast.getMaxTemp()) + "C" + "\n" +
                "Feels like: " + converter.convertTemperature(forecast.getFeelsLike()) + "C" + "\n" +
                "Humidity: " + forecast.getHumidity() + "\n" +
                "Pressure: " + forecast.getPressure() + "\n" +
                "Current time: " + converter.convertTimeZone(forecast.getTimezone()) + "\n" +
                "https://openweathermap.org/img/w/" + forecast.getIcon() + ".png";
    }
}
