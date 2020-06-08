import bot.CityTimeWeatherBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TelegramBot {

    public static void main(String[] args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new CityTimeWeatherBot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

}
