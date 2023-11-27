package bot.handler;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

public class TextHandler {
    public static void handle(final Message message, final TelegramLongPollingBot bot) throws TelegramApiException {
        if (message.getText().equals("Menu")) {
            ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("\uD83C\uDF54 Burgers").build(),
                            KeyboardButton.builder().text("\uD83E\uDD57 Salads").build()
                    )))
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("\uD83C\uDF79 Beverages").build()
                    )))
                    .keyboardRow(new KeyboardRow(List.of(
                            KeyboardButton.builder().text("⬅ Back").build()
                    )))
                    .build();
            replyKeyboardMarkup.setResizeKeyboard(true);
            SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "What would you choose?");
            sendMessage.setReplyMarkup(replyKeyboardMarkup);
            bot.execute(sendMessage);

        } else if (message.getText().equals("\uD83C\uDF54 Burgers")) {
            burgersButton(message, bot);
        } else if (message.getText().equals("\uD83E\uDD57 Salads")) {
            saladsButton(message, bot);
        } else if (message.getText().equals("\uD83C\uDF79 Beverages")) {
            beverageButton(message,bot);
        } else if (message.getText().equals("⬅ Back")) {
            CommandHandler.handleMessageSTART(message, bot);
        }
    }

    @SneakyThrows
    private static void beverageButton(final Message message, final TelegramLongPollingBot bot) {
        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Montella").callbackData("montella").build(),
                        InlineKeyboardButton.builder().text("Fanta").callbackData("fanta").build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Sprite").callbackData("sprite").build()
                ))
                .build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Beverages: ");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    private static void saladsButton(final Message message, final TelegramLongPollingBot bot) {
        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Caesar").callbackData("caesar").build(),
                        InlineKeyboardButton.builder().text("Greek").callbackData("greek").build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Sesame").callbackData("sesame").build()
                ))
                .build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Salads: ");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        bot.execute(sendMessage);
    }


    @SneakyThrows
    private static void burgersButton(final Message message, final TelegramLongPollingBot bot) {
        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Classic burger").callbackData("classic").build(),
                        InlineKeyboardButton.builder().text("Chicken cheese-burger").callbackData("cheese").build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder().text("Barbeque burger").callbackData("barbeque").build(),
                        InlineKeyboardButton.builder().text("Double chicken cheese-burger").callbackData("double").build()
                ))
                .build();
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Burgers: ");
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
        bot.execute(sendMessage);
    }
}
