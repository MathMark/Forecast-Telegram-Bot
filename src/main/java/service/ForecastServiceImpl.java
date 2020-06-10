package service;

import api.mapping.Mapper;
import api.requester.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import presenter.Presenter;

@Component
public class ForecastServiceImpl implements ForecastService {
    @Autowired
    private Requester requester;

    @Autowired
    private Mapper mapper;

    @Autowired
    private Presenter presenter;

    @Override
    public String getForecast(String cityName) {
        String forecast = "";
        try{
            forecast = presenter.getPresentation(mapper.mapToModel(requester.getJsonFromURL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=330a370093d85a95a83474ca5483c00c")));
        }catch (Exception e){
            e.printStackTrace();
            //forecast = "Unknown city";
        }
        return forecast;
    }

}
