import bot.CityWeatherBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@Component
@ComponentScan({"bot","api","metricsConverter","presenter","service", "config"})
public class TelegramBot {

    @Autowired
    private CityWeatherBot cityWeatherBot;

    @Autowired
    private TelegramBotsApi telegramBotsApi;

    public static void main(String[] args){
        ConfigurableApplicationContext appContext = SpringApplication.run(TelegramBot.class, args);
        TelegramBot telegramBot = (TelegramBot)appContext.getBean("telegramBot");
        telegramBot.initializeBot();
    }

    static {
        ApiContextInitializer.init();
    }

    private void initializeBot(){
        try{
            telegramBotsApi.registerBot(cityWeatherBot);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
