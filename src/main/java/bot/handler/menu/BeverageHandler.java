package bot.handler.menu;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class BeverageHandler {
    @SneakyThrows
    public static void montella(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/montella.png")));
        sendPhoto.setCaption("Montella \n" +
                "\n" +
                " \n" +
                "Цена: 3 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void sprite(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/sprite.png")));
        sendPhoto.setCaption("SPRITE \n" +
                "\n" +
                " \n" +
                "Цена: 8 000  сум");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void fanta(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/fanta.png")));
        sendPhoto.setCaption("FANTA \n" +
                "\n" +
                " \n" +
                "Цена: 8 000  сум");
        bot.execute(sendPhoto);
    }
}
