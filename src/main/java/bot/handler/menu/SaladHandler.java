package bot.handler.menu;

import bot.handler.ButtonUtilsOfMenu;
import bot.repo.ProductRepo;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.File;

public class SaladHandler {

    @SneakyThrows
    public static void caesar(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 5));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/caesar.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(4).getName() +
                "\n\n" + ProductRepo.PRODUCT_LIST.get(4).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(4).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void greek(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 6));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/greek.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(5).getName() +
                "\n\n" + ProductRepo.PRODUCT_LIST.get(5).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(5).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

    @SneakyThrows
    public static void sesame(final Message message, final TelegramLongPollingBot bot) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setReplyMarkup(ButtonUtilsOfMenu.buildProductMarkup(1, 7));
        sendPhoto.setChatId(message.getChatId());
        sendPhoto.setPhoto(new InputFile(new File("src/main/java/bot/photo_resources/salads/sesame.png")));
        sendPhoto.setCaption(ProductRepo.PRODUCT_LIST.get(6).getName() +
                "\n\n" + ProductRepo.PRODUCT_LIST.get(6).getDescription() +
                "Price:  " + ProductRepo.PRODUCT_LIST.get(6).getPrice() + " sum");
        bot.execute(sendPhoto);
    }

}
