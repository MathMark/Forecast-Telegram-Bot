package service;

import api.mapping.Mapper;
import api.mapping.MapperImpl;
import api.requester.Requester;
import api.requester.RequesterImpl;
import presenter.Presenter;
import presenter.PresenterImpl;

public class ForecastServiceImpl implements ForecastService {
    private Requester requester;
    private Mapper mapper;
    private Presenter presenter;

    public ForecastServiceImpl(){
        requester = new RequesterImpl();
        mapper = new MapperImpl();
        presenter = new PresenterImpl();
    }

    @Override
    public String getForecast(String cityName) {
        String forecast = "";
        try{
            forecast = presenter.getPresentation(mapper.mapToModel(requester.getJsonFromURL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=330a370093d85a95a83474ca5483c00c")));
        }catch (Exception e){
            forecast = "Unknown city";
        }
        return forecast;
    }
}
