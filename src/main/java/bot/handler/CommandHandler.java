package bot.handler;

import bot.command_enum.CommandEnum;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class CommandHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        switch (CommandEnum.of(message.getText())) {
            case START:
                handleMessageSTART(message, bot);
            case HELP:
                handleMessageHELP(message, bot);
        }
    }


    @SneakyThrows
    public static void handleMessageSTART(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83D\uDECD Order").build())))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Welcome!");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    private static void handleMessageHELP(final Message message, final TelegramLongPollingBot bot) {

    }
}
