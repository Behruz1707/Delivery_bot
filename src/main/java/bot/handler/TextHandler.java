package bot.handler;

import bot.handler.menu.BeverageHandler;
import bot.handler.menu.BurgerHandler;
import bot.handler.menu.SaladHandler;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
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
            beverageButton(message, bot);
        } else if (message.getText().equals("⬅ Back")) {
            CommandHandler.handleMessageSTART(message, bot);
        }
        // burgers
        else if (message.getText().equals("Classic burger")) {
            BurgerHandler.classicBurger(message, bot);
        } else if (message.getText().equals("Chicken cheese-burger")) {
            BurgerHandler.cheeseBurger(message, bot);
        } else if (message.getText().equals("Barbeque burger")) {
            BurgerHandler.barbequeBurger(message, bot);
        } else if (message.getText().equals("Double chicken cheese-burger")) {
            BurgerHandler.doubleBurger(message, bot);
        }
        // salads
        else if (message.getText().equals("Caesar")) {
            SaladHandler.caesar(message, bot);
        } else if (message.getText().equals("Sesame")) {
            SaladHandler.sesame(message, bot);
        } else if (message.getText().equals("Greek")) {
            SaladHandler.greek(message, bot);
        }
        // beverages
        else if (message.getText().equals("Fanta")) {
            BeverageHandler.fanta(message, bot);
        } else if (message.getText().equals("Montella")) {
            BeverageHandler.montella(message, bot);
        } else if (message.getText().equals("Sprite")) {
            BeverageHandler.sprite(message, bot);
        }

        // back
        else if (message.getText().equals("◀\uFE0F Back")){
            back(message,bot);
        }
    }

    @SneakyThrows
    private static void back(final Message message, final TelegramLongPollingBot bot) {
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
    }

    @SneakyThrows
    private static void beverageButton(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Montella").build(),
                        KeyboardButton.builder().text("Fanta").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sprite").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("◀\uFE0F Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Beverages: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }

    @SneakyThrows
    private static void saladsButton(final Message message, final TelegramLongPollingBot bot) {
        ReplyKeyboardMarkup replyKeyboardMarkup = ReplyKeyboardMarkup.builder()
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Caesar").build(),
                        KeyboardButton.builder().text("Greek").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("Sesame").build()
                )))
                .keyboardRow(new KeyboardRow(List.of(
                        KeyboardButton.builder().text("◀\uFE0F Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Salads: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }


    @SneakyThrows
    private static void burgersButton(final Message message, final TelegramLongPollingBot bot) {
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
                        KeyboardButton.builder().text("◀\uFE0F Back").build()
                )))
                .build();
        replyKeyboardMarkup.setResizeKeyboard(true);
        SendMessage sendMessage = new SendMessage(message.getChatId().toString(), "Burgers: ");
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        bot.execute(sendMessage);
    }
}
