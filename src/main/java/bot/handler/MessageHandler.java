package bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageHandler {
    @SneakyThrows
    public static void handle(final Message message, final TelegramLongPollingBot bot) throws TelegramApiException {
        if (message.isCommand()) {
            CommandHandler.handle(message, bot);
        } else if (message.hasText()) {
            TextHandler.handle(message,bot);
        }
    }
}
