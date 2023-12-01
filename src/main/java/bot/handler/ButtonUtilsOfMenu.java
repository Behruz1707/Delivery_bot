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

import java.util.List;

public class ButtonUtilsOfMenu {

    @SneakyThrows
    public static void back(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83C\uDF54 Burgers").build(),
                        KeyboardButton.builder().text("\uD83E\uDD57 Salads").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83C\uDF79 Beverages").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83D\uDCE5 Basket").build(),
                        KeyboardButton.builder().text("⬅ Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "What would you choose?");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void beverageButton(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Montella").build(),
                        KeyboardButton.builder().text("Fanta").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sprite").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("⬅ Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Beverages: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void saladsButton(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Caesar").build(),
                        KeyboardButton.builder().text("Greek").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sesame").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("⬅ Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Salads: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }


    @SneakyThrows
    public static void burgersButton(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Classic burger").build(),
                        KeyboardButton.builder().text("Chicken cheese-burger").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Barbeque burger").build(),
                        KeyboardButton.builder().text("Double chicken cheese-burger").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("⬅ Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Burgers: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    public static void menuButtons(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83C\uDF54 Burgers").build(),
                        KeyboardButton.builder().text("\uD83E\uDD57 Salads").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83C\uDF79 Beverages").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("\uD83D\uDCE5 Basket").build(),
                        KeyboardButton.builder().text("⬅ Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "What would you choose?");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);

    }

    public static InlineKeyboardMarkup buildProductMarkup(int quantity, long productId) {
        return InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text("-")
                                .callbackData("-;" + quantity + ";" + productId)
                                .build(),
                        InlineKeyboardButton.builder()
                                .text(String.valueOf(quantity))
                                .callbackData("number")
                                .build(),
                        InlineKeyboardButton.builder()
                                .text("+")
                                .callbackData("+;" + quantity + ";" + productId)
                                .build()
                ))
                .keyboardRow(List.of(
                        InlineKeyboardButton.builder()
                                .text("\uD83D\uDCE5Add to the basket✅")
                                .callbackData("basket;" + productId + ";" + quantity)
                                .build()
                ))
                .build();
    }

}
