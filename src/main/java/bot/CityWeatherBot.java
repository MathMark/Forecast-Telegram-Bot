package bot;

import api.requester.RequesterImpl;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ResourceBundle;

public class CityWeatherBot extends TelegramLongPollingBot {

    private static ResourceBundle resource = ResourceBundle.getBundle("bot");

    private static String botUserName = resource.getString("bot.name");
    private static String botToken = resource.getString("bot.token");

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if(message != null && message.hasText()){
            switch (message.getText()){
                case "/start":
                    sendTelegramMessage(update, "Welcome to forecast bot! Please type city name to find out forecast.");
                    break;
                case "/help":
                    sendTelegramMessage(update, "How can I help?");
                    break;
                default: sendTelegramMessage(update, new RequesterImpl().getDataFromURL("https://api.openweathermap.org/data/2.5/weather?q=" + update.getMessage().getText() + "&appid=330a370093d85a95a83474ca5483c00c"));
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

    private void sendTelegramMessage(Update update, String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(text);
        sendMessage.setReplyToMessageId(update.getMessage().getMessageId());

        try {
            execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
