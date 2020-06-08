package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ResourceBundle;

public class CityTimeWeatherBot extends TelegramLongPollingBot {

    private static ResourceBundle resource = ResourceBundle.getBundle("bot");

    private static String botUserName = resource.getString("bot.name");
    private static String botToken = resource.getString("bot.token");

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage s = new SendMessage();
        s.setChatId(update.getMessage().getChatId());
        s.setText(update.getMessage().getText());
        s.setReplyToMessageId(update.getMessage().getMessageId());
        try{
            execute(s);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }
}
