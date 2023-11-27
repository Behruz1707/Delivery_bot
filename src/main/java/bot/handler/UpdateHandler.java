package bot.handler;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UpdateHandler {
    public static void handle(final Update update, final TelegramLongPollingBot bot) throws TelegramApiException {
        if (update.hasCallbackQuery()) {
            CallbackQueryHandler.handle(update.getCallbackQuery(), bot);
        } else if (update.hasMessage()) {
            MessageHandler.handle(update.getMessage(), bot);
        }
    }
}
