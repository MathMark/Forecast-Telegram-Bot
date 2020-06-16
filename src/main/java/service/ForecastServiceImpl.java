package service;

import api.mapping.Mapper;
import api.requester.Requester;
import bot.replies.Reply;
import model.Forecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForecastServiceImpl implements ForecastService {

    private static Logger logger = LoggerFactory.getLogger(ForecastServiceImpl.class);

    @Autowired
    private Requester requester;

    @Autowired
    private Mapper mapper;

    @Override
    public Forecast getForecast(String cityName) {
        Forecast forecast = null;
        try{
            forecast = mapper.mapToModel(requester.getJsonFromURL("https://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=330a370093d85a95a83474ca5483c00c"));
        }catch (Exception e){
            logger.error(e.getMessage());

        }
        return forecast;
    }

}
