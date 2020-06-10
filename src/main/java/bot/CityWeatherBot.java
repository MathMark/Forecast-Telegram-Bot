package bot;

import bot.replies.Reply;
import model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import service.ForecastService;
import java.util.ResourceBundle;

@Component
public class CityWeatherBot extends TelegramLongPollingBot {

    private static ResourceBundle resource = ResourceBundle.getBundle("bot");

    private static String botUserName = resource.getString("bot.name");
    private static String botToken = resource.getString("bot.token");

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private Reply reply;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            Forecast forecast = forecastService.getForecast(update.getMessage().getText());
            if(forecast != null){
                sendTelegramMessage(update, reply.sayWeather(forecast));
            }else{
                sendTelegramMessage(update, reply.responseNegatively());
            }
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

    private void sendTelegramMessage(Update update, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(text);
        sendMessage.setReplyToMessageId(update.getMessage().getMessageId());

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
