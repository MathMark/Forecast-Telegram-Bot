package model;

import annotations.JsonField;
import java.util.Objects;

public class Forecast {
    //main":{"temp":303.35,"feels_like":302.26,"temp_min":301.48,"temp_max":305.37,"pressure":1002,"humidity":38},
    @JsonField(path = "/sys/country")
    private String country;

    @JsonField(path = "/name")
    private String cityName;

    @JsonField(path = "/main/temp")
    private Double temperature;

    @JsonField(path = "/main/temp_min")
    private Double minTemp;

    @JsonField(path = "/main/temp_max")
    private Double maxTemp;

    @JsonField(path = "/main/humidity")
    private Integer humidity;
    @JsonField(path = "/main/pressure")
    private Integer pressure;

    @JsonField(path = "/main/feels_like")
    private Double feelsLike;

    @JsonField(path = "/timezone")
    private Integer timezone;

    @JsonField(path = "/weather/0/description")
    private String weatherDescription;

    @JsonField(path = "/weather/0/icon")
    private String icon;

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

    @Override
    public String toString() {
        return "Forecast{" +
                "country='" + country + '\'' +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", feelsLike=" + feelsLike +
                ", timezone=" + timezone +
                ", weatherDescription='" + weatherDescription + '\'' +
                '}';
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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
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

    public double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
