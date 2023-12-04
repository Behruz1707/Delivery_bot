package bot.handler.menu;

import bot.handler.ButtonUtilsOfMenu;
import bot.repo.ProductRepo;
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
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 8));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/montella.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(7).getName() +
                "\n\nPrice:  " + ProductRepo.PRODUCT_LIST.get(7).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void sprite(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 10));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/sprite.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(8).getName() +
                "\n\nPrice:  " + ProductRepo.PRODUCT_LIST.get(8).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void fanta(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 9));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/beverages/fanta.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(9).getName() +
                "\n\nPrice:  " + ProductRepo.PRODUCT_LIST.get(9).getPrice() + " sum");
        bot.execute(sendPhoto);
    }
}
