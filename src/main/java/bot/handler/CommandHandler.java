package bot.handler;

import bot.command_enum.CommandEnum;
import bot.repo.BasketRepo;
import bot.repo.Maps;
import bot.repo.Steps;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.HashMap;
import java.util.List;

public class CommandHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) {
        if (CommandEnum.of(message.getText()) == CommandEnum.START) {
            handleMessageSTART(message, bot);
        }
    }


    @SneakyThrows
    public static void handleMessageSTART(final Message message, final TelegramLongPollingBot bot) {
        BasketRepo.BASKET_MAP = new HashMap<>();
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83D\uDECD Order").build())))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Welcome!");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

}
