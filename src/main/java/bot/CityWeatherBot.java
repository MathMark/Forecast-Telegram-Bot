package bot;

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

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String forecast = forecastService.getForecast(update.getMessage().getText());
            sendTelegramMessage(update, forecast);
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
