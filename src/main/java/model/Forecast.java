package model;

import java.text.DateFormat;
import java.util.Objects;

public class Forecast {
    private String country;
    private String cityName;
    private int temperature;
    private int minTemp;
    private int maxTemp;
    private int humidity;
    private int pressure;
    private int feelsLike;
    private DateFormat timezone;
    private String weatherDescription;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forecast forecast = (Forecast) o;
        return temperature == forecast.temperature &&
                minTemp == forecast.minTemp &&
                maxTemp == forecast.maxTemp &&
                humidity == forecast.humidity &&
                pressure == forecast.pressure &&
                feelsLike == forecast.feelsLike &&
                country.equals(forecast.country) &&
                cityName.equals(forecast.cityName) &&
                timezone.equals(forecast.timezone) &&
                weatherDescription.equals(forecast.weatherDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, cityName, temperature, minTemp, maxTemp, humidity, pressure, feelsLike, timezone, weatherDescription);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(int feelsLike) {
        this.feelsLike = feelsLike;
    }

    public DateFormat getTimezone() {
        return timezone;
    }

    public void setTimezone(DateFormat timezone) {
        this.timezone = timezone;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
