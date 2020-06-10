package service;

import model.Forecast;

public interface ForecastService {
    Forecast getForecast(String cityName);
}
