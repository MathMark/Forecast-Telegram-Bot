package bot.replies;

import com.vdurmont.emoji.EmojiParser;
import metricsConverter.MetricsConverter;
import model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReplyEnglish implements Reply {

    private static final String NEXT_LINE = "\n";
    private static final String C = "C";
    private static final String SKIP_LINE = "\n\n";

    @Autowired
    private MetricsConverter converter;

    @Override
    public String responseNegatively() {
        return "Sorry, mate " + EmojiParser.parseToUnicode(":cry:") + "\nI don't know such city. Check if you did not make any mistake in the name of a city.";
    }

    @Override
    public String sayWeather(Forecast forecast) {
        return "Hey! I know the weather in " + forecast.getCityName() + " for today." + SKIP_LINE +
                "Country: " + forecast.getCountry() + " " + EmojiParser.parseToUnicode(":" + forecast.getCountry().toLowerCase() + ":") + NEXT_LINE +
                "Weather: " + forecast.getWeatherDescription() + NEXT_LINE +
                "The lowest temperature for today is " + converter.convertTemperature(forecast.getMinTemp()) + C +
                " " + "and the highest is " + converter.convertTemperature(forecast.getMaxTemp()) + C + NEXT_LINE +
                "Temperature now is " + converter.convertTemperature(forecast.getTemperature()) + C +
                " " + "but feels like " + + converter.convertTemperature(forecast.getFeelsLike()) + C + NEXT_LINE +
                "Humidity: " + forecast.getHumidity() + NEXT_LINE +
                "Pressure: " + forecast.getPressure() + SKIP_LINE +
                "Current time: " + converter.convertTimeZone(forecast.getTimezone()) + SKIP_LINE +
                "https://openweathermap.org/img/w/" + forecast.getIcon() + ".png";
    }

    @Override
    public String offerHelp() {
        return "How can I help you, mate? " + EmojiParser.parseToUnicode(":stuck_out_tongue_winking_eye:");
    }
}
