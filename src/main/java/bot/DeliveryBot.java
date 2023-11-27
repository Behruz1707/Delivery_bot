package bot;

import bot.handler.UpdateHandler;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static bot.BotConfigure.BOT_TOKEN;
import static bot.BotConfigure.BOT_USERNAME;

public class DeliveryBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            UpdateHandler.handle(update, this);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public DeliveryBot() {
        super(BOT_TOKEN);
    }

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }
}
