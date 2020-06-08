import api.mapping.Mapper;
import api.mapping.MapperImpl;
import api.requester.Requester;
import api.requester.RequesterImpl;
import bot.CityWeatherBot;
import model.Forecast;
import org.json.JSONObject;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class TelegramBot {

    public static void main(String[] args){
        Requester requester = new RequesterImpl();
        JSONObject f = requester.getJsonFromURL("https://api.openweathermap.org/data/2.5/weather?q=London&appid=330a370093d85a95a83474ca5483c00c");

        Mapper mapper = new MapperImpl();
        Forecast forecast = mapper.mapToModel(f);

        System.out.println(forecast);

        /*ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new CityWeatherBot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }*/
    }

}
