package presenter;

import metricsConverter.MetricsConverter;
import metricsConverter.MetricsConverterImpl;
import model.Forecast;

public class PresenterImpl implements Presenter {
    @Override
    public String getPresentation(Forecast forecast) {
        MetricsConverter converter = new MetricsConverterImpl();

        return "Country: " + forecast.getCountry() + "\n" +
                "City: " + forecast.getCityName() + "\n" +
                "Temperature: " + converter.convertTemperature(forecast.getTemperature()) + "C" + "\n" +
                "Min temperature: " + converter.convertTemperature(forecast.getMinTemp()) + "C" + "\n" +
                "Max temperature: " + converter.convertTemperature(forecast.getMaxTemp()) + "C" + "\n" +
                "Feels like: " + converter.convertTemperature(forecast.getFeelsLike()) + "C" + "\n" +
                "Humidity: " + forecast.getHumidity() + "\n" +
                "Pressure: " + forecast.getPressure() + "\n" +
                "Current time: " + converter.convertTimeZone(forecast.getTimezone());
    }
}
