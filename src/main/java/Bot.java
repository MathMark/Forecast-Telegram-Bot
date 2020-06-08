import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;
import java.util.ResourceBundle;

public class Bot extends TelegramLongPollingBot {

    private static ResourceBundle resource = ResourceBundle.getBundle("bot");

    public static void main(String...args){
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try{
            telegramBotsApi.registerBot(new Bot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {

    }

    public void onUpdatesReceived(List<Update> updates) {

    }

    public String getBotUsername() {
        return resource.getString("botName");
    }

    public String getBotToken() {
        return resource.getString("token");
    }
}
