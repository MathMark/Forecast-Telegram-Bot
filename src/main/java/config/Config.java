package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.TelegramBotsApi;

@Configuration
public class Config {

    @Bean
    public TelegramBotsApi telegramBotsApi(){
        return new TelegramBotsApi();
    }
}
