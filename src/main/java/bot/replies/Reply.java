package bot.replies;

import model.Forecast;

public interface Reply {
    String responseNegatively();
    String sayWeather(Forecast forecast);
    String offerHelp();
    String initialReply();
}
